package com.example.book_crud.service;


import com.example.book_crud.entity.Book;
import com.example.book_crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> saveAllBook( List<Book> books){
        return bookRepository.saveAll(books);
    }


    public Book updateBook(Long id ,Book book){
        return bookRepository.findById(id).map(book1 -> {
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setPrice(book.getPrice());
            book1.setYear(book.getYear());
            return bookRepository.save(book1);
        }).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}