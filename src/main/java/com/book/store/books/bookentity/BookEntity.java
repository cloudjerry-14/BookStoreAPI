package com.book.store.books.bookentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookTable")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	private String name;
	private String author;
	
	public BookEntity(int bookId, String name, String author) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
	}

	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", name=" + name + ", author=" + author + "]";
	}
	

}
