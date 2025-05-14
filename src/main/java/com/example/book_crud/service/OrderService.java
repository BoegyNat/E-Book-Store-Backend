package com.example.book_crud.service;

import com.example.book_crud.entity.Book;
import com.example.book_crud.entity.Order;
import com.example.book_crud.entity.User;
import com.example.book_crud.repository.BookRepository;
import com.example.book_crud.repository.OrderRepository;
import com.example.book_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Order> getOrdersByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUser(user);
    }

    public Order createOrder(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        Order order = new Order();
        order.setUser(user);
        order.setBook(book);
        return orderRepository.save(order);
    }
}
