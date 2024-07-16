package com.masai.service;

import com.masai.dto.BookDTO;
import com.masai.exception.BooksException;
import com.masai.model.Book;

import java.util.List;

public interface BookService {
    Book registerNewBook(Book book);
    List<BookDTO> getBooks() throws BooksException;
}
