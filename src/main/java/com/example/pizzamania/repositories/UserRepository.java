package com.example.pizzamania.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pizzamania.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
