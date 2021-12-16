
package com.example.reto4.repositories;

import com.example.reto4.models.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.reto4.repositories.interfaces.ProductInterface;


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
    
    public Product save(Product product) {
        return crud.save(product);
    }

    public void deleteById(String reference) {
        crud.deleteByReference(reference);
    }

    
}
