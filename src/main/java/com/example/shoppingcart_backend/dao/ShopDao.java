package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopDao extends CrudRepository<Shop,Integer> {
    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `products` WHERE `name`=:name",nativeQuery = true)
    List<Shop> searchProduct(@Param("name") String name);
}
