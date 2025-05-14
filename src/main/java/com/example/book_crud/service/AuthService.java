package com.example.book_crud.service;

import com.example.book_crud.dto.AuthRequest;
import com.example.book_crud.dto.AuthResponse;
import com.example.book_crud.entity.Role;
import com.example.book_crud.entity.User;
import com.example.book_crud.security.JwtUtils;
import com.example.book_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;


    public AuthResponse signup(AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);
        String token = jwtUtils.generateToken(user.getUsername(), user.getRole().name());
        return new AuthResponse("User registered successfully",token);
    }



    public AuthResponse login(AuthRequest request) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(request.getUsername()));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtUtils.generateToken(user.getUsername(), user.getRole().name());
                return new AuthResponse("Login successful", token);

            }
        }
        throw new RuntimeException("Invalid username or password");
    }

}
