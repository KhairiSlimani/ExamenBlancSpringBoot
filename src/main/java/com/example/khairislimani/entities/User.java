package com.example.khairislimani.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fName;
    private String lName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private List<Project> projects;

    @OneToMany
    private List<Project> projectList;

}
