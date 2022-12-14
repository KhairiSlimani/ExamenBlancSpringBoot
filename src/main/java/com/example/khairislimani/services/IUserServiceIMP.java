package com.example.khairislimani.services;

import com.example.khairislimani.entities.User;
import com.example.khairislimani.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IUserServiceIMP implements IUserService{

    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
