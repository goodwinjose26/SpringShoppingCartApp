package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomersDao extends CrudRepository<Customers,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phno`, `username` FROM `customer` WHERE `username`=:username AND`password`=:password",nativeQuery = true)
    List<Customers> login(@Param("username") String username,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phno`, `username` FROM `customer` WHERE `id`=:id",nativeQuery = true)
    List<Customers> profileview(@Param("id") Integer id);
}
