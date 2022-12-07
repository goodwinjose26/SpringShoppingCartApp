package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.CustomersDao;
import com.example.shoppingcart_backend.dao.ShopDao;
import com.example.shoppingcart_backend.model.Customers;
import com.example.shoppingcart_backend.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class ShopController {
    @Autowired
    private ShopDao dao;
    @Autowired
    private CustomersDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> add(@RequestBody Shop s)
    {
        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/reg",consumes = "application/json",produces = "application/json")
     public Map<String,String> reg(@RequestBody Customers c)
    {
        dao1.save(c);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

@CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Shop> view()
    {
        return (List<Shop>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Shop> searchProduct(@RequestBody Shop s)
    {
        String name=String.valueOf(s.getName());
        System.out.println(name);
        return (List<Shop>) dao.searchProduct(name);

    }









}
