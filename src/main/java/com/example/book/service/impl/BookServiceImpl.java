package com.example.book.service.impl;

import com.example.book.entity.BookEntity;
import com.example.book.mapper.BookMapper;
import com.example.book.model.book.SearchRequestDto;
import com.example.book.model.request.BookRequest;
import com.example.book.model.response.BookResponse;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.book.mapper.BookMapper.updateBook;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper mapper;


    @Override
    public Page<BookResponse> getListBook(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookEntity -> mapper.map(bookEntity, BookResponse.class));
    }

    @Override
    public Page<BookResponse> getBooks(Pageable pageable, SearchRequestDto searchRequestDto) {
//        BookSpecification bookSpecification = new BookSpecification(searchRequestDto);
//       return bookRepository.findAll(bookSpecification, pageable)
//                .map(bookEntity -> mapper.map(bookEntity, BookResponse.class));
        return null;
    }

    @Override
    public BookResponse getBooks(Long id) {
        var books = fetchExists(id);
        return BookMapper.mapToBookResponse(books);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(bookEntity ->
                        mapper.map(bookEntity, BookResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByID(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void updateBooks(Long id, BookRequest bookRequest) {
        bookRepository.save(updateBook(bookRequest, fetchExists(id)));
    }

    @Override
    public void saveBooks(BookRequest request) {
        bookRepository.save(BookMapper.mapToBookEntity(request));
    }

    private BookEntity fetchExists(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT_FOUND_BOOK"));
    }
}
