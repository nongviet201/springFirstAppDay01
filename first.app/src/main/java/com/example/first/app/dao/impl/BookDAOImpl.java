package com.example.first.app.dao.impl;

import com.example.first.app.dao.BookDAO;
import com.example.first.app.database.BookDB;
import com.example.first.app.model.Book;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.first.app.database.BookDB.books;

@Repository
public class BookDAOImpl implements BookDAO {

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
//        for (Book book : books){
//            if(book.getId() == id){
//                return book;
//            }
//        }
//        return null;
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Book> sortByYear() {
//        List<Book> sortedBooks = (List<Book>) Stream.of(books);
        /*int n = sortedBooks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedBooks.get(j).getYear() > sortedBooks.get(j + 1).getYear()) {
                    Book temp = sortedBooks.get(j);
                    sortedBooks.set(j, sortedBooks.get(j + 1));
                    sortedBooks.set(j + 1, temp);
                }
            }
        }
        return sortedBooks;*/

        return books.stream().sorted(Comparator.comparingInt(Book::getYear)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByName(String name) {
//        List<Book> getByName = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getTitle().equalsIgnoreCase(name) || book.getTitle().contains(name)) {
//                getByName.add(book);
//            }
//        }
//        return getByName;
        return books.stream().filter(b -> b.getTitle().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByYear(int yearStart, int yearEnd) {
//        List<Book> getByYear = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getYear() >= yearStart && book.getYear() <= yearEnd) {
//                getByYear.add(book);
//            }
//        }
//        return getByYear;
        return books.stream().filter(b -> b.getYear() >= yearStart && b.getYear() <= yearEnd).collect(Collectors.toList());
    }


}


