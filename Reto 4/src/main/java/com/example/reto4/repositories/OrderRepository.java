/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.reto4.repositories;

import com.example.reto4.models.Order;
import com.example.reto4.repositories.interfaces.OrderInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeremy
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface crud;
    
    public List<Order> getAll(){
        return crud.findAll();
    }
    
    public Optional<Order> getById(Integer id){
        return crud.findById(id);
    }
    
    public Order save(Order order){
        return crud.save(order);
    }
    
    public void deleteById(Integer id){
        crud.deleteById(id);
    }
    
    // < READ - User By Status>
    public List<Order> getOrderByStatus(String status) {
        return crud.findByStatus(status);
    }
    
    public List<Order> getZone(String zone){
        return crud.findUserByZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return crud.findUserById(id);
    }



}
