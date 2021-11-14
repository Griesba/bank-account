package com.griesba.kata.banking.services.impl;

import com.griesba.kata.banking.User;
import com.griesba.kata.banking.controllers.UserDto;
import com.griesba.kata.banking.repository.UserRepository;
import com.griesba.kata.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public User create(UserDto userDto) {
        return userRepository.save(User.builder().name(userDto.getName()).build());
    }
}
