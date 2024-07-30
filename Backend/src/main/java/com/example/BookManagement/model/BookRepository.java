package com.example.BookManagement.model;

import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
