
package com.example.reto5.repositories.interfaces;

import com.example.reto5.models.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductInterface extends MongoRepository<Product, Integer> {
    
    public List<Product> findByPrice(double price);
    
    public Optional<Product> findByReference(String reference);
    
    
    
}
