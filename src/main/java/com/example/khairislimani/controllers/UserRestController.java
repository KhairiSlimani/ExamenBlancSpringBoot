package com.example.khairislimani.controllers;

import com.example.khairislimani.entities.User;
import com.example.khairislimani.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    IUserService iUserService;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return iUserService.addUser(user);
    }

}
