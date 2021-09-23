package com.example.spring_boot_jwt.services;


import com.example.spring_boot_jwt.authen.UserPrincipal;
import com.example.spring_boot_jwt.entities.User;

public interface UserService {
    public User createUser(User user);
    public UserPrincipal findByUsername(String username);
}
