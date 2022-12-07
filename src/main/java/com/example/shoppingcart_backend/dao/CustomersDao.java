package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customers,Integer> {
}
