package com.griesba.kata.banking.services.impl;

import com.griesba.kata.banking.Role;
import com.griesba.kata.banking.User;
import com.griesba.kata.banking.controllers.UserDto;
import com.griesba.kata.banking.repository.UserRepository;
import com.griesba.kata.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
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
        if (Strings.isEmpty(userDto.getRole())) {
            throw new RuntimeException("Error: missing user role.");
        }
        try {
            Role role = Role.valueOf(userDto.getRole());
            return userRepository.save(User.builder().name(userDto.getName()).role(role).build());
        }catch (Exception e) {
            log.error("Error: invalid user.", e);
            throw new RuntimeException("Error: invalid user.");
        }
    }
}
