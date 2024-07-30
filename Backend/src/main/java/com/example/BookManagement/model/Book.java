package com.example.BookManagement.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Book")
public class Book {
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Double getBookprice() {
		return bookprice;
	}
	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}
	
	@Id
	@Column (name = "bookid")
    private Long bookid;
	@Column (name = "booktitle")
    private String booktitle;
	@Column (name = "genre")
    private String genre;
	@Column (name = "bookprice")
    private Double bookprice;

}