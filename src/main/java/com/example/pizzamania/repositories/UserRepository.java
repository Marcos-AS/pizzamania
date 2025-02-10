package com.example.pizzamania.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.pizzamania.User;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
