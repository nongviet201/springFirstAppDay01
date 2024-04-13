package com.example.first.app.services;

import com.example.first.app.model.Book;

import java.util.List;

public interface BookServices {
    List<Book> getAllBook();

    Book getBookByID(int id);

    List<Book> sortByYear();

    List <Book> getBookByName(String name);

    List<Book> getBookByYear(int yearStart, int yearEnd);
}
