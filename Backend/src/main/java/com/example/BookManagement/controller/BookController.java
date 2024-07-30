package com.example.BookManagement.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookManagement.exception.BookNotFoundException;
import com.example.BookManagement.model.Author;
import com.example.BookManagement.model.Book;
import com.example.BookManagement.model.BookRepository;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

	@GetMapping("/retrieveByBook/:bookid")

	public Book retrieve(@PathVariable("bookid") int id) {
		Optional<Book> project = bookRepo.findById(id);

		if (project.isEmpty()) {
			return null;
		} else {
			return project.get();
		}

	}
	
	@PostMapping("/insert")
	public Book insertData(@RequestBody Book bk) {
		return bookRepo.save(bk);
	}
	
	@GetMapping("/retrieveBooks")
	public List<Book> display(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/retrieveByBook/{bookid}")

	public ResponseEntity<Book> bookbyid(@PathVariable("bookid") int id)
	{
		Book b=bookRepo.findById(id).orElseThrow(()->new BookNotFoundException());
		return ResponseEntity.ok(b);
	}

	
    @DeleteMapping("/deleteBook/{bookid}")
    public void deleteData(@PathVariable("bookid") int id) {
        bookRepo.deleteById(id);
    }
    
	@PutMapping("/updateBook/{bookid}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookid") int id,@RequestBody
			Book b1)
	{
		Book b=bookRepo.findById(id).orElseThrow(()->new BookNotFoundException());;
	System.out.println("Value coming in backend is "+b1.getBookprice());
		b.setBookid(b1.getBookid());
		b.setBooktitle(b1.getBooktitle());
		b.setBookprice(b1.getBookprice());
		b.setGenre(b1.getGenre());
		System.out.println("Price is "+b1.getBookprice());
		System.out.println("updated vaue is "+b.getBookprice());
		Book updatedbook=bookRepo.save(b);
		return ResponseEntity.ok(updatedbook);
	}

}