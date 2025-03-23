package com.revature.project1.controller;

import com.revature.project1.Entities.Account;
import com.revature.project1.Entities.Address;
import com.revature.project1.service.AddressService;
import com.revature.project1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    private final UserService userService;

    public AddressController(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllAddress(HttpServletRequest httpServletRequest){
        if(httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if(account.getRole().getRoleId() == 2) { //Is a manager, only manager can see all addresses
                List<Address> addresses = addressService.findAllAddress();
                return ResponseEntity.ok(addresses);
            } else{
                return ResponseEntity.ok("error: You have no permission to take this action!");
            }
        }else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id, HttpServletRequest httpServletRequest){
        if(httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");

            if()
        }else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
        return addressService.findAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address, HttpServletRequest httpServletRequest){

        Address savedAddress = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails, HttpServletRequest httpServletRequest){
        return addressService.updateAddress(id, addressDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
