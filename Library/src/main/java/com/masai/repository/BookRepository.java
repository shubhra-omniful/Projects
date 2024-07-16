package com.masai.repository;

import com.masai.dto.BookDTO;
import com.masai.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(" select new com.masai.dto.BookDTO(book.title, book.author, book.publisher) from Book book")
    List<BookDTO> getBooks();

}