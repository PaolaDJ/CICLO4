package com.example.reto4.services;

import com.example.reto4.models.User;
import com.example.reto4.repositories.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> getAll() {
        return repo.getAll();
    }

    public User getById(Integer id) {
        Optional<User> exist = repo.getById(id);
        
        if (exist.isPresent()) {
            return exist.get();
            
        } return new User();
        
    }
    
    // <EXISTS - EMAIL>
    
    public boolean getUserByEmail(String email) {
        return repo.getUserByEmail(email).isPresent();
    }
    
    // <AUTHENTICATE - USER>
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repo.getUserByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }

    public User save(User user) {
        if (user.getIdentification() == null || user.getName()== null ||
        user.getMonthBirthtDay() == null || user.getAddress()== null ||
        user.getCellPhone()== null || user.getEmail()== null ||
        user.getPassword()== null || user.getZone()== null ||
        user.getType()== null) {
            return user;
            
        } else {
            if (user.getId() == null) {
                return repo.save(user);
                    
            } else {
                Optional<User> userExist2 = repo.getById(user.getId());
                if (userExist2.isEmpty()) {
                    return repo.save(user);

                } else {
                    return user;

                }

            }
            
        }
        
    }
    
    public User update(User user){
        if(user.getId() != null){
            Optional<User> exist = repo.getById(user.getId());
            if (!exist.isEmpty()){
                if(user.getIdentification() !=null){
                    exist.get().setIdentification(user.getIdentification());   
                }
                if(user.getName() !=null){
                    exist.get().setName(user.getName());
                }
                if(user.getAddress() !=null){
                    exist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone() !=null){
                    exist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail() !=null){
                    exist.get().setEmail(user.getEmail());
                }
                if(user.getPassword() !=null){
                    exist.get().setPassword(user.getPassword());
                }
                if(user.getZone() !=null){
                    exist.get().setZone(user.getZone());
                }
                if(user.getType() !=null){
                    exist.get().setType(user.getType());
                }
                
                return repo.save(exist.get());      
                
            } return user;
            
        } return user;
        
    }
    
    // <DELETE - BY ID>
    public boolean delete(Integer id) {
        Optional<User> user = repo.getById(id);
        if (user.isPresent()) {
            repo.deleteByID(id);
            return true;
            
        } return false;
        
    }
 
    
    
}

