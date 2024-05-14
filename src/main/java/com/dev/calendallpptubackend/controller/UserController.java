package com.dev.calendallpptubackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.calendallpptubackend.model.User;
import com.dev.calendallpptubackend.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService _userService;

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(_userService.getAllUsers());
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        User response = _userService.findUserByEmail(user.getEmail());

        if(response != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with the provided email is already registered.");
        }
        
        return ResponseEntity.ok(_userService.createUser(user));
    }
    

}
