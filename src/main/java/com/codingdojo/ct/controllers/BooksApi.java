package com.codingdojo.ct.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.ct.models.Book;
import com.codingdojo.ct.services.BookService;


@RestController
public class BooksApi {
    private final BookService BookService;
    
    public BooksApi(BookService bookService){
        this.BookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return BookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return BookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = BookService.findBook(id);
        return book;
    }
}
