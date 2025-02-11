package com.example.pizzamania.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.pizzamania.entities.User;
import com.example.pizzamania.repositories.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user!=null) {
                return user;
            }
            throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado.");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/crear", "/orders").hasRole("USER") //protege estas rutas, hasRole() asume que se prefija con ROLE_
                    //.requestMatchers("/h2-console/**").permitAll()
                    .requestMatchers("/", "/**").permitAll()) //todas las demas permitidas
                .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers
                    .frameOptions(frame -> frame.disable())) //permite mostrar la consola h2 en un iframe
                .formLogin(form -> form
                    .loginPage("/login") //setea cuál es la página de login
                    .defaultSuccessUrl("/crear")) //setea a qué página va una vez logueado
                .oauth2Login(login -> login
                    .loginPage("/login")
                    .defaultSuccessUrl("/inicioGoogle"))
                .logout(logout -> logout
                    .invalidateHttpSession(true)) //un filtro que intercepta peticiones POST con /logout
                .build();
    }
}
