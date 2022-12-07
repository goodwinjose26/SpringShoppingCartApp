package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopDao extends CrudRepository<Shop,Integer> {
}
