package com.example.first.app.ultils;

import com.example.first.app.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface IFileReader {


    List<Book> readFile(String path);
}
