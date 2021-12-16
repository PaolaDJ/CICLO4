
package com.example.reto4.services;

import com.example.reto4.models.Product;
import com.example.reto4.repositories.ProductRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    public List<Product> getAll() {
        return repo.getAll();
    }

    // < READ - BY ID >
    public Product getByID(String reference) {
        Optional<Product> exists = repo.getById(reference);
        if (exists.isPresent()) {
            return exists.get();
            
        } return new Product();
    }
    
    
    // < CREATE - NEW PRODUCT >
    public Product save(Product product) {
        if (product.getBrand() == null || product.getCategory()== null ||
        product.getDescription()== null || product.getPrice()== 0.0 ||
        product.getQuantity()== 0 || product.getPhotography() == null) {
            return product;
            
        } else {
            Optional<Product> exist = repo.getById(product.getReference());
            if (exist.isEmpty()) {
                return repo.save(product);
                
            } return product;
            
        }
        
    }

    public Product update(Product product) {
        if (product.getReference()!= null) {
            Optional<Product> productDB = repo.getById(product.getReference());
            if (!productDB.isEmpty()) {
                
                if (product.getBrand()!= null) {
                    productDB.get().setBrand(product.getBrand());
                }
                if(product.getCategory()!= null){
                    productDB.get().setCategory(product.getCategory());
                }
                if(product.getDescription()!= null){
                    productDB.get().setDescription(product.getDescription());
                }
                if(true){
                    productDB.get().setAvailability(product.getAvailability());
                }                
                
                if (product.getPrice() != 0.0) {
                    productDB.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDB.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDB.get().setPhotography(product.getPhotography());
                }
               
                return repo.save(productDB.get());
                
            } return product;
            
        } return product;
        
    }

    // <DELETE>
    public boolean delete(String reference) {
        Optional<Product> exists = repo.getById(reference);
        if (exists.isPresent()) {
            repo.deleteById(reference);
            return true;
            
        } return false;
        
    }
    

}
