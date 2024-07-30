package com.example.BookManagement.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "Author")
public class Author {
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	@Id
	@Column (name = "authorid")
	private int authorid;
	@Column (name = "authorname")
	private String authorname;
	@OneToMany 
	@JoinColumn(name = "authorid")
	private List<Book> booklist;
	

}