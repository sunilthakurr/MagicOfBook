package com.example.BookManagement.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
