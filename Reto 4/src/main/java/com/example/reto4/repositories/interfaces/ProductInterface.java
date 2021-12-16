
package com.example.reto4.repositories.interfaces;

import com.example.reto4.models.Product;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductInterface extends MongoRepository<Product, Integer> {
    
    public Optional<Product> findByReference(String reference);
    
    public void deleteByReference(String reference);
    
}
