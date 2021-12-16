
package com.example.reto5.services;

import com.example.reto5.models.Product;
import com.example.reto5.repositories.ProductRepo;
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

   public Optional<Product> getByID(String reference) {
        return repo.getById(reference);
    }

    public Product save(Product accesory) {
        if (accesory.getReference()== null) {
            return accesory;
        } else {
            return repo.create(accesory);
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
               
                
                return repo.create(productDB.get());
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getByID(reference).map(product -> {
            repo.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List <Product> findByPrice (double price){
        return  repo.findByPrice(price);
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.indexOf(string2)>=0;
    }
    
    public List <Product> findByDescription (String description2){
        List <Product> suplementos = repo.getAll();
        ArrayList<Product> suplementos2 = new ArrayList();
        for(Product suplemento: suplementos){
            String descripcion1 = suplemento.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                suplementos2.add(suplemento);
            }
            
        }
        
        return (List<Product>) suplementos2;
    }

}
