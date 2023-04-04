package com.example.book.repository;

import com.example.book.entity.BookEntity;
import com.example.book.service.spesification.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findBookEntitiesByAmount(Long aLong);

    Page<BookEntity> findAll(BookSpecification bookSpecification, Pageable pageable);
}
