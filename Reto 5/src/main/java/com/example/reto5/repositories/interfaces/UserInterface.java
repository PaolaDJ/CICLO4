package com.example.reto5.repositories.interfaces;


import com.example.reto5.models.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
     
    
    public List <User> findByMonthBirthtDay (String birthday);
}

