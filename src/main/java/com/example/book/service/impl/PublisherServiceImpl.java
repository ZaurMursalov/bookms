package com.example.book.service.impl;

import com.example.book.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl {
    private final PublisherRepository publisherRepository;
}
