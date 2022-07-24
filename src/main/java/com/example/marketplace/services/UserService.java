package com.example.marketplace.services;

import com.example.marketplace.models.User;
import com.example.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional()
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void register(User user) {
        userRepository.save(user);
    }
   public void deleteUser(Integer id){
       userRepository.deleteById(id);
   }

   public void setBuyer(int userId, Integer id) {
        userRepository.setBuyer(userId, id);
   }

    public List<User> productBuyer(int id){
        return userRepository.productBuyer(id);
    }
}
