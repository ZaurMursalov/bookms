package com.example.book.controller;

import com.example.book.model.book.SearchRequestDto;
import com.example.book.model.request.BookRequest;
import com.example.book.model.response.BookResponse;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBooks(id);
    }

    @GetMapping("/list")
    public List<BookResponse> getAllBook() {
        return bookService.getAllBooks();
    }


    @GetMapping("/test")
    public Page<BookResponse> getListBook(Pageable pageable) {
        return bookService.getListBook(pageable);
    }

    @GetMapping("/search")
    public Page<BookResponse> getBooks(Pageable pageable, SearchRequestDto bookCriteria) {
        return bookService.getBooks(pageable, bookCriteria);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable Long id) {
        bookService.deleteByID(id);
    }


    @PatchMapping("/{id}/amount")
    public void updateBookById(@PathVariable Long id, @RequestParam BookRequest amount) {
        bookService.updateBooks(id, amount);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBookData(@RequestBody BookRequest request) {
        bookService.saveBooks(request);
    }
}
