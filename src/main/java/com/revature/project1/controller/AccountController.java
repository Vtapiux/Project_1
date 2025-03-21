package com.revature.project1.controller;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.revature.project1.Entities.Account;
import com.revature.project1.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {this.accountService = accountService;}

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        Map<String, Object> response = new HashMap<>();
        if (newAccount.getUsername() != null) {
            if (newAccount.getRole() != null) {
                response.put("message: ", "The account was successfully created!");
                response.put("account: ", newAccount);
            }
            else {
                response.put("error: ", "Invalid role!");
            }
        }
        else {
            response.put("error: ", "This user account already exists!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Account account, HttpServletRequest servletRequest) {
        Account existingUser = accountService.loginUser(account.getUsername(), account.getPassword());
        Map<String, Object> response = new HashMap<>();
        if (servletRequest.getSession(false) == null) {
            if (existingUser != null) {
                if (BCrypt.verifyer().verify(account.getPassword().toCharArray(), existingUser.getPassword()).verified) {
                    HttpSession httpSession = servletRequest.getSession(true);
                    httpSession.setAttribute("newAccount", account);
                    httpSession.setAttribute("roleId", account.getRole().getRoleId());
                    response.put("message: ", "Successful login!");
                    response.put("account: ", existingUser);
                }
                else {
                    response.put("error: ", "Invalid credentials!");
                }
            }
            else {
                response.put("error: ", "Invalid credentials!");
            }
        }
        else {
            response.put("error: ", "Invalid action (a session is in progress)!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/logout")
    public ResponseEntity<HashMap<String, String>> logout(HttpServletRequest servletRequest) {
        HashMap<String, String> response = new HashMap<>();
        if (servletRequest.getSession(false) != null) {
            servletRequest.getSession(false).invalidate();
            response.put("message: ", "Successful logout!");
        }
        else {
            response.put("error: ", "Invalid action (no session in progress)!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public Long getRoleId(HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession(false);
        if (session != null && session.getAttribute("roleId") != null){
            return(Long)session.getAttribute("roleId");
        }
        return null;
    }
}