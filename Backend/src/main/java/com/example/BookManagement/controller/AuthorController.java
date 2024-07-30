package com.example.BookManagement.controller;

import com.example.BookManagement.model.Author;
import com.example.BookManagement.model.AuthorRepository;
import com.example.BookManagement.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@CrossOrigin("http://localhost:4200")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    
	@GetMapping("/retrieveauthor")
	public List<Author> retrieveData() {
		return authorRepository.findAll();
	}

	@GetMapping("/retrieveByAuthor/{authorid}")

	public Author retrieve(@PathVariable("authorid") int id) {
		Optional<Author> auth = authorRepository.findById(id);
		if (auth.isEmpty()) {
			return null;
		} else {
			return auth.get();
		}

	}
	
	@PostMapping("/insert")
	public Author insertData(@RequestBody Author auth) {
		return authorRepository.save(auth);
	}
	
    // Update an author
    @PutMapping("/update/{authorid}")
    public Author updateAuthor(@PathVariable("authorid") int id, @RequestBody Author updatedAuthor) {
        return authorRepository.findById(id)
            .map(author -> {
                author.setAuthorname(updatedAuthor.getAuthorname());
                author.setBooklist(updatedAuthor.getBooklist());
                return authorRepository.save(author);
            })
            .orElseGet(() -> {
                updatedAuthor.setAuthorid(id);
                return authorRepository.save(updatedAuthor);
            });
    }
    
    // Delete an author
    @DeleteMapping("/delete/{authorid}")
    public void deleteAuthor(@PathVariable("authorid") int id) {
        authorRepository.deleteById(id);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return authorRepository.findBybooklist_booktitleContaining(title);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return authorRepository.findBybooklist_genreContaining(genre);
    }

    @GetMapping("/author/{authorName}")
    public List<Author> getBooksByAuthor(@PathVariable String authorName) {
        return authorRepository.findByauthornameContaining(authorName);
    }
}
