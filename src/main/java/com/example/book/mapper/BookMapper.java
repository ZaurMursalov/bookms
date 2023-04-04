package com.example.book.mapper;

import com.example.book.entity.BookEntity;
import com.example.book.model.request.BookRequest;
import com.example.book.model.response.BookResponse;

public class BookMapper {

    public static BookEntity mapToBookEntity(BookRequest bookRequest) {
        return BookEntity.builder()
                .amount(bookRequest.getAmount())
                .description(bookRequest.getDescription())
                .title(bookRequest.getTitle())
                .build();
    }

    public static BookResponse mapToBookResponse(BookEntity bookEntity) {
        return BookResponse.builder()
                .id(bookEntity.getId())
                .amount(bookEntity.getAmount())
                .title(bookEntity.getTitle())
                .description(bookEntity.getDescription())
                .build();
    }

    public static BookEntity updateBook(BookRequest request, BookEntity entity) {
        entity.setAmount(request.getAmount());
        entity.setDescription(request.getDescription());
        entity.setTitle(request.getTitle());
        return entity;
    }

}
