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
        dao.save(e);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Shop> searchEmployee(@RequestBody Shop s)
    {
        String empcode=String.valueOf(s.getEmpcode());
        System.out.println(empcode);
        return (List<Shop>) dao.searchEmployee(e.getEmpcode());
    }

    @CrossOrigin(origins = "*")

    @GetMapping("/view")
    public List<Employee> view()
    {
        return  (List<Employee>) dao.findAll();
    }






}
