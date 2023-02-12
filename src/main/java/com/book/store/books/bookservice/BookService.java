package com.book.store.books.bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.books.bookentity.BookEntity;
import com.book.store.books.bookrepo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookEntity> getAllBooks() {
		List<BookEntity> list=(List<BookEntity>)this.bookRepository.findAll();		
		return list;
	}
	
	public BookEntity getBookById(int bId) {
		BookEntity result=null;	
		result= this.bookRepository.findById(bId);				
		return result;

	}
	
	public BookEntity addBook(BookEntity b) {
		BookEntity result = bookRepository.save(b);
		return result;
	}
	
	public void deleteBook(int bId) {
		bookRepository.deleteById(bId);
	}
	
	public void updateBook(BookEntity b, int bId) {
		b.setBookId(bId);
		bookRepository.save(b);
	}
	

	
	
	
	

}
