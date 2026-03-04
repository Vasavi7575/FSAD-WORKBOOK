package com.klu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    // In-memory list
    private List<Book> bookList = new ArrayList<>();

    // 1. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    // 2. /count
    @GetMapping("/count")
    public int getTotalBooks() {
        return bookList.size();
    }

    // 3. /price
    @GetMapping("/price")
    public double getSamplePrice() {
        return 499.99;
    }

    // 4. /books (List of titles)
    @GetMapping("/books")
    public List<String> getBookTitles() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "Hibernate Essentials");
    }

    // 5. /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "You searched for book titled: " + title;
    }

    // 7. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. /addbook (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}