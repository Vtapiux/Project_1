package com.revature.project1.controller;

import com.revature.project1.Entities.User;
import com.revature.project1.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers(HttpServletRequest httpServletRequest){
        if (httpServletRequest.getSession(false) != null){
            List<User> users = userService.getUsers();
            return ResponseEntity.ok(users);
        }
        else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user, HttpServletRequest httpServletRequest){
        if (httpServletRequest.getSession(false) != null){
            int roleId = (int) httpServletRequest.getAttribute("roleId");
            if(roleId == 2){
                System.out.println(roleId);
            }
            User userResponse = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        }
        else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }
}