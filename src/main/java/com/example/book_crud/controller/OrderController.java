package com.example.book_crud.controller;

import com.example.book_crud.entity.Order;
import com.example.book_crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @PostMapping("/user/{userId}/book/{bookId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long userId, @PathVariable Long bookId) {
        return ResponseEntity.ok(orderService.createOrder(userId, bookId));
    }
}
