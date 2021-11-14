package com.griesba.kata.banking.services;

import com.griesba.kata.banking.User;
import com.griesba.kata.banking.controllers.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    User findOne(UUID id);

    User create(UserDto userDto);
}
