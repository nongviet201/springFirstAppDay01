package com.example.first.app.controller;

import com.example.first.app.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", "J,K",1997));
        books.add(new Book(2, "Harry Potter", "J,K",1997));
        books.add(new Book(3, "Harry Potter", "J,K",1997));
    }

    // lấy danh sách tất cả book
    // GET https//localhost:8080/books
    @GetMapping
    public List<Book> getAllBook() {
        return books;
    }



    // lấy thông tin của sách theo id
    // GET http://localhost:8080/books/1, https//localhost:8080/books/2,...
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // ném ra ngoại lệ
    }

}
