package com.masai.service;

import com.masai.dto.BookDTO;
import com.masai.exception.BooksException;
import com.masai.model.Book;
import com.masai.repository.BookRepository;
import com.masai.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Book registerNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookDTO> getBooks() throws BooksException {
        List<BookDTO> books= bookRepository.getBooks();
        if ( books.isEmpty() ) throw new BooksException("No books available");
        return books;
    }
}
