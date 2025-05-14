package com.example.book_crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100)
    private String password;

    // Getters & Setters
    public  String getUsername() {return username;}
    public void setUsername(String username){this.username=username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password =password;}

}
