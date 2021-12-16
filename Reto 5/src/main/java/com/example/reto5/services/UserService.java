package com.example.reto5.services;

import com.example.reto5.models.User;
import com.example.reto5.repositories.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.getUser(id);
    }

    public User save(User user) {
        if (user.getId() != null) {
            Optional<User> usuario = userRepository.getUser(user.getId());
            if (usuario.isEmpty()) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public User update(User user){
        if(user.getId() != null){
            Optional<User> usuario = userRepository.getUser(user.getId());
            if (!usuario.isEmpty()){
                if(user.getIdentification() !=null){
                    usuario.get().setIdentification(user.getIdentification());   
                }
                if(user.getName() !=null){
                    usuario.get().setName(user.getName());
                }
                if(user.getAddress() !=null){
                    usuario.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone() !=null){
                    usuario.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail() !=null){
                    usuario.get().setEmail(user.getEmail());
                }
                if(user.getPassword() !=null){
                    usuario.get().setPassword(user.getPassword());
                }
                if(user.getZone() !=null){
                    usuario.get().setZone(user.getZone());
                }
                if(user.getType() !=null){
                    usuario.get().setType(user.getType());
                }
                userRepository.update(usuario.get());
                return usuario.get();            
            }
        }else{
            return user;
        }
        return user;
    }
    
    public boolean delete(Integer id){
        boolean usuario= getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return usuario;
    }
 
    
    public List<User> findByMonthBirthtDay (String birthday){
        return  userRepository.findByMonthBirthtDay(birthday);
    }
    
}

