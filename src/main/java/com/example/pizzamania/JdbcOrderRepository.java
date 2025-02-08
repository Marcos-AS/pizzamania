package com.example.pizzamania;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    //para guardar una orden, se guarda la orden, luego todas las pizzas de la orden
    //y los ingredientes de cada pizza (ingredientRef)
    //ademas se debe determinar el ID que se le asigna a la orden cuando se guarda
    //como en la BD id es identity la BD lo determina automáticamente
    //pero se necesita conocerlo para devolver el obj PizzaOrder
    //para esto sirve GeneratedKeyHolder que involucra trabajar con un prepared statement
    @Override
    @Transactional
    public PizzaOrder save(PizzaOrder order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
            "insert into Pizza_Order "
            + "(delivery_name, delivery_street, delivery_city, "
            + "delivery_province, delivery_PC, cc_number, "
            + "cc_expiration, cc_cvv, placed_at) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true); //para luego obtener el ID de la orden
        
        order.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
            Arrays.asList( //se pasan los valores que se insertarán
                order.getDeliveryName(),
                order.getDeliveryStreet(),
                order.getDeliveryCity(),
                order.getDeliveryProvince(),
                order.getDeliveryCP(),
                order.getCcNumber(),
                order.getCcExpiration(),
                order.getCcCVV(),
                order.getPlacedAt()
            )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue(); //una vez hecho el update, keyHolder tiene el ID
        order.setId(orderId);

        List<Pizza> pizzas = order.getPizzas();
        int i = 0;
        for (Pizza pizza : pizzas) {
            savePizza(orderId, i++, pizza); //ahora deben guardarse cada pizza
        }
        
        return order;
    }
                
    private long savePizza(long orderId, int orderKey, Pizza pizza) {
        pizza.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
            "insert into Pizza (name, created_at, pizza_order, pizza_order_key) "
            + "values (?, ?, ?, ?)",
            Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);
        
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
            Arrays.asList(
                pizza.getName(),
                pizza.getCreatedAt(),
                orderId,
                orderKey
            )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long pizzaId = keyHolder.getKey().longValue();
        pizza.setId(pizzaId);
        saveIngredientRefs(pizzaId, pizza.getIngredients());
        return pizzaId;
    }

    private void saveIngredientRefs(long pizzaId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                "insert into Ingredient_Ref (ingredient, pizza, pizza_key) "
                + "values (?, ?, ?)",
                ingredientRef.getIngredient(), 
                pizzaId,
                key++
            );
        }
    }
}