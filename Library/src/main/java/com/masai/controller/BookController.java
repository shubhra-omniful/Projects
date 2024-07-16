package com.masai.controller;

import com.masai.dto.BookDTO;
import com.masai.exception.BooksException;
import com.masai.model.Book;
import com.masai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public ResponseEntity<Book> registerNewBook(@RequestBody Book book){
        Book savedBook = bookService.registerNewBook(book);
       return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getBooks() throws BooksException {
        List<BookDTO> newBook = bookService.getBooks();
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

}
