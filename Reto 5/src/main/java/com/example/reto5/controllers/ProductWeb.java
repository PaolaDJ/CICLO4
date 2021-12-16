package com.example.reto5.controllers;

import com.example.reto5.models.Product;
import com.example.reto5.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cleaningproduct")
@CrossOrigin("*")
public class ProductWeb {
    @Autowired
    private ProductService service;
       
    @GetMapping("/all")
    public List<Product> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getByID(@PathVariable("id") String id) {
        return service.getByID(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
    
    @GetMapping("/price/{price}")
    public List<Product> findByPrice(@PathVariable("price") double price) {
        return service.findByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Product> findByDescription(@PathVariable("description") String description) {
        return service.findByDescription(description);
    }  
    
}
