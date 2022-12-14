package com.example.khairislimani.repositories;

import com.example.khairislimani.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByRoleAndFNameAndLName(String role, String fName, String lName);
    public User findUserByFNameAndLName(String fName, String lName);
}
