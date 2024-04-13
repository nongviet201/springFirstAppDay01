package com.example.first.app.services.impl;

import com.example.first.app.dao.BookDAO;
import com.example.first.app.model.Book;
import com.example.first.app.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServicesImpl implements BookServices {

    @Autowired
    private BookDAO bookDAO;
    @Override
    public List<Book> getAllBook() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookByID(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> sortByYear() {
        return bookDAO.sortByYear();
    }

    @Override
    public List<Book> getBookByName(String name) {
        return bookDAO.getBookByName(name);
    }

    @Override
    public List<Book> getBookByYear(int yearStart, int yearEnd) {
        return bookDAO.getBookByYear(yearStart, yearEnd);
    }
}
