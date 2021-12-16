/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.reto4.services;

import com.example.reto4.models.Order;
import com.example.reto4.repositories.OrderRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Jeremy
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repo;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Order> getAll() {
        return repo.getAll();
    }
    
    // < READ - ORDER BY ID >
    public Order getByID(Integer id) {
        Optional<Order> exists = repo.getById(id);
        if (exists.isPresent()) {
            return exists.get();
                    
        } return new Order();
    }
    
    // < READ - USERS BY ZONE >
    public List<Order> getUsersByZone(String zone) {
        return repo.getZone(zone);
    }
    
    // < CREATE - NEW ORDER >
    public Order save(Order order) {
        if (order.getRegisterDay() == null || order.getStatus() == null ||
        order.getSalesMan() == null || order.getProducts() == null ||
        order.getQuantities() == null) {
            return order;
            
        } else {
            Optional<Order> exists = repo.getById(order.getId());
            if (exists.isEmpty()) {
                return repo.save(order);
                
            } return order;
            
        }
        
    }
    
    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orden = repo.getById(order.getId());
            if(!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                
                return repo.save(orden.get());
                
            } return order;
            
        } return order;
        
    }
    
    // <DELETE>
    public boolean delete(Integer id) {
        Optional<Order> exists = repo.getById(id);
        if (exists.isPresent()) {
            repo.deleteById(id);
            return true;
            
        } return false;
        
    }
    

    // < READ - USERS BY ID >
    public List<Order> getUsersById(Integer id) {
        return repo.getBySalesManId(id);
    }
    
    
    // < READ - USERS BY STATUS >
    public List<Order> getOrderByStatus(String status) {
        return repo.getOrderByStatus(status);
    }

    public List<Order> getByStatusAndByUserId(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
    }
    
    // < READ - User By ID AND ORDER BY DATE>
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
        
    }
    

}
