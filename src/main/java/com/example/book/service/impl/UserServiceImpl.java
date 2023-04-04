package com.example.book.service.impl;

import com.example.book.mapper.UserMapper;
import com.example.book.model.request.UserRequest;
import com.example.book.repository.UserRepository;
import com.example.book.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void logIn(UserRequest userRequest) {
        log.info("ActionLog.savePayment.start");
        userRepository.save(UserMapper.mapToEntity(userRequest));
        log.info("ActionLog.savePayment.success");
    }
}
