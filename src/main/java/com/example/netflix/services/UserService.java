package com.example.netflix.services;

import com.example.netflix.models.Role;
import com.example.netflix.models.UserModel;
import com.example.netflix.repos.UserRepository;
import com.example.netflix.utils.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) { return userRepository.findById(id).get(); }

    public UserModel register(AuthDTO authDTO) throws Exception {
        Optional<UserModel> existingUser = userRepository.findUserByUsername(authDTO.username);
        if (existingUser.isPresent()) {
            throw new Exception("User already exists!");
        }
        if(authDTO.password.equals(authDTO.secondPassword)) {
            UserModel userModel = UserModel.from(authDTO);
            return userRepository.save(userModel);
        }
        else {
            throw new Exception("Passwords don't match!");
        }
    }

    public UserModel login(AuthDTO authDTO) throws Exception {
        UserModel userModel = userRepository.findUserByUsername(authDTO.username).orElseThrow();

        if(userModel.getPassword().equals(authDTO.password)) {
            return userModel;
        }
        else {
            throw new Exception("Incorrect credentials!");
        }
    }

    public String unregister(AuthDTO authDTO) throws Exception {
        if(authDTO.password.equals(authDTO.secondPassword)) {
            userRepository.deleteUserByUsername(authDTO.username);
            return "User deleted successfully!";
        }
        else {
            throw new Exception("Passwords don't match!");
        }
    }

    public UserModel findByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initAdmin() {
        userRepository.save(new UserModel("admin", "admin", Role.ADMIN, new ArrayList<>(),new ArrayList<>()));
    }
}
