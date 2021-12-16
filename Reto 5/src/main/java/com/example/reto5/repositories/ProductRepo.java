
package com.example.reto5.repositories;

import com.example.reto5.models.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.reto5.repositories.interfaces.ProductInterface;


@Repository
public class ProductRepo {
    
    @Autowired
    private ProductInterface crud;

    public List<Product> getAll() {
        return crud.findAll();
    }

    public Optional<Product> getById(String reference) {
        return crud.findByReference(reference);
    }
    public Product create(Product supplements) {
        return crud.save(supplements);
    }

    public void update(Product supplements) {
        crud.save(supplements);
    }
    
    public void delete(Product supplements) {
        crud.delete(supplements);
    }
    
    public List <Product> findByPrice (double price){
        return  crud.findByPrice(price);
    }
    

    
}
