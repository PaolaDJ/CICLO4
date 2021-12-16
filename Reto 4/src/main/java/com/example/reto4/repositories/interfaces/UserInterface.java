package com.example.reto4.repositories.interfaces;


import com.example.reto4.models.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
    
    // SEARCH IF AN EMAIL IS REGISTERED
    public Optional<User> findByEmail(String email);
    
    // SEARCH THE COMBINATION OF EMAIL AND PASSWORD OF AN USER
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}

