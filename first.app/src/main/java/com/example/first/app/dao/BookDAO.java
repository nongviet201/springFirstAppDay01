package com.example.first.app.dao;

import com.example.first.app.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();

    Book findById(int id);

    List<Book> sortByYear();

    List<Book> getBookByName(String name);

    List<Book> getBookByYear(int yearStart, int yearEnd);
}
