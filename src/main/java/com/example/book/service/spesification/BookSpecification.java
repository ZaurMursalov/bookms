package com.example.book.service.spesification;

import com.example.book.entity.BookEntity;
import com.example.book.model.book.SearchRequestDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookSpecification implements Specification<BookEntity> {

    private final SearchRequestDto searchRequestDto;

    public BookSpecification(SearchRequestDto searchRequestDto) {
        this.searchRequestDto = searchRequestDto;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (searchRequestDto.getTitle() != null && !searchRequestDto.getTitle().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("title"), "%" + searchRequestDto.getTitle() + "%"));
        }
        if (searchRequestDto.getAmount() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("amount"), searchRequestDto.getAmount()));
        }
        if (searchRequestDto.getDescription() != null && !searchRequestDto.getDescription().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("description"), "%" + searchRequestDto.getDescription() + "%"));
        }
        return predicate;
    }
}