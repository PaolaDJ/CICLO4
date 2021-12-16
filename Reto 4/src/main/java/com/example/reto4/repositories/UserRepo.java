package com.example.reto4.repositories;

import com.example.reto4.models.User;
import com.example.reto4.repositories.interfaces.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepo {
    @Autowired
    private UserInterface crud;
    
    public List<User> getAll(){
        return crud.findAll();
    }
    
    public Optional<User> getById(Integer id){
        return crud.findById(id);
    }    
    
    // <USER BY EMAIL>
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    // <USER EMAIL AND PASSWORD>
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    
    public User save(User user){
        return crud.save(user);
    }
    
    
    public void deleteByID(Integer id){
        crud.deleteById(id);
    }
    
    
}
