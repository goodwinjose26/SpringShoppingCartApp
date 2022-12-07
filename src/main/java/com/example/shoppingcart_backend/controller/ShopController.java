package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.ShopDao;
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
    @GetMapping("/view")
    public List<Shop> view()
    {
        return (List<Shop>) dao.findAll();
    }












}
