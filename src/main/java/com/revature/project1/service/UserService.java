package com.revature.project1.service;

import com.revature.project1.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User createUser(User user);
    Optional<User> getUserById();
    User updateUser();

}
