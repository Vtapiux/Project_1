package com.revature.project1.controller;

import com.revature.project1.Entities.User;
import com.revature.project1.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        User userResponse = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

}
