package com.example.reto5.repositories;

import com.example.reto5.models.User;
import com.example.reto5.repositories.interfaces.UserInterface;
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
    
    public Optional<User> getUser(Integer id){
        return crud.findById(id);
    }    
    
    
    public User save(User user){
        return crud.save(user);
    }
    
    public void update(User user){
        crud.save(user);
    }
    
    public void delete(User user){
        crud.delete(user);
    }
    
    public List<User> findByMonthBirthtDay (String birthday){
        return  crud.findByMonthBirthtDay(birthday);
    }
    
}
