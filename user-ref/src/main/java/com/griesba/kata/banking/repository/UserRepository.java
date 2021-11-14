package com.griesba.kata.banking.repository;

import com.griesba.kata.banking.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
