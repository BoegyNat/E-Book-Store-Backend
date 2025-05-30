package com.example.book_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 50)
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role must be specified")
    private Role role;

    // Getters & Setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public String getPassword() {return password;}
    public void  setPassword(String password){this.password = password;}

    public  Role getRole () {return role;}
    public void setRole(Role role){this.role=role;}





}

