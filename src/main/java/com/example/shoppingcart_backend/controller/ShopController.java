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
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Customers c)
    {
        String username=String.valueOf(c.getUsername());
        String password=String.valueOf(c.getPassword());
       // return (List<Customers>) dao1.login(username,password);
List<Customers> result=(List<Customers>) dao1.login(username,password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;

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


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profileview",consumes = "application/json",produces = "application/json")
    public List<Customers> profileview(@RequestBody Customers c)
    {
        String id=String.valueOf(c.getId());
        System.out.println(id);
        return (List<Customers>) dao1.profileview(c.getId());

    }









}
