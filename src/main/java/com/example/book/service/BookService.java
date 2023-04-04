package com.example.book.service;

import com.example.book.model.book.SearchRequestDto;
import com.example.book.model.request.BookRequest;
import com.example.book.model.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<BookResponse> getBooks(Pageable pageable, SearchRequestDto bookCriteria);

    BookResponse getBooks(Long id);

    List<BookResponse> getAllBooks();

    void deleteByID(Long id);

    void updateBooks(Long id, BookRequest bookRequest);

    void saveBooks(BookRequest request);

    Page<BookResponse> getListBook(Pageable pageable);

}
