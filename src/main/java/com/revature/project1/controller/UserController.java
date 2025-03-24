package com.revature.project1.controller;

import com.revature.project1.Entities.Account;
import com.revature.project1.Entities.User;
import com.revature.project1.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("get_all/")
    public ResponseEntity<Object> getUsers(HttpServletRequest httpServletRequest){
        if (httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if (account.getRole().getRoleId() == 2) {
                List<User> users = userService.getUsers();
                return ResponseEntity.ok(users);
            }
            else {
                return ResponseEntity.ok("error: You have no permission to take this action!");
            }
        }
        else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }

    @PostMapping("new_user/")
    public ResponseEntity<?> createUser(@RequestBody User user, HttpServletRequest httpServletRequest){
        if (httpServletRequest.getSession(false) != null){
            User userResponse = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        }
        else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }
}