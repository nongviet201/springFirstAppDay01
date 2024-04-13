package com.example.first.app.controller;

import com.example.first.app.model.Book;
import com.example.first.app.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
* @Controller: tra ve template. ngoài ra co the tra ve du lieu o dang JSON, XML  // khi su dung phai co @ResponseBody
* @RestController: tra ve du lieu json, xml,...
* @RestController = @Controller + @ResponseBody
* Class ResponseEntity<T>: dai dien cho 1 HTTP Response, bao gom status code, headers va body
* */


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServices bookServices;

    // tra ve templace index, html nao nam tron muc resouce, templace
    @GetMapping("/home")
    public  String getHome() {
        return "index";
    }

    // lấy danh sách tất cả book
    // GET https//localhost:8080/books
    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED) //201
    public List<Book> getAllBook() {
        return bookServices.getAllBook();
    }

//    @GetMapping("getAllBook")
//    public ResponseEntity<?> getAllBook1() {
//        return new ResponseEntity<>(books,HttpStatus.CREATED);
//    }

    // lấy thông tin của sách theo id
    // GET http://localhost:8080/books/1, https//localhost:8080/books/2,...
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        return bookServices.getBookByID(id);
    }

    @GetMapping("/sortByYear")
    @ResponseBody
    public List<Book> sortByYear() {
        return bookServices.sortByYear();
    }

    @GetMapping("/search/{name}")
    @ResponseBody
    public List <Book> getBookByName(@PathVariable String name) {
        return bookServices.getBookByName(name);
    }


    @GetMapping("/startYear/{startYear}/endYear/{endYear}")
    @ResponseBody
    public List <Book> getBookByYear(@PathVariable int startYear, @PathVariable int endYear) {
        return bookServices.getBookByYear(startYear, endYear);
    }


}
