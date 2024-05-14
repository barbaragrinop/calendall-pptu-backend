package com.dev.calendallpptubackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.calendallpptubackend.model.User;
import com.dev.calendallpptubackend.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository _userRepository;

    public UserService() {}

    public User createUser(User user) {
        _userRepository.save(user);
        return user;
    }   

    public List<User> getAllUsers(){
        return _userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    public User findUserByEmail(String email) {
        return _userRepository.findByEmail(email);
    }
}
