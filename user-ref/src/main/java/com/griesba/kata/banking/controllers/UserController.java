package com.griesba.kata.banking.controllers;

import com.griesba.kata.banking.User;
import com.griesba.kata.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        if (userDto == null || Strings.isEmpty(userDto.getName())) {
            return ResponseEntity.ok("Error creating user");
        } else {
            User user = userService.create(userDto);
            return ResponseEntity.ok("User created with success");
        }
    }
}
