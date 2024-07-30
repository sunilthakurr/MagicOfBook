package com.example.BookManagement.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Book> findBybooklist_booktitleContaining(String title);

    List<Book> findBybooklist_genreContaining(String genre);

    List<Author> findByauthornameContaining(String authorName);
}