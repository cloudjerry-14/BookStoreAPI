package com.book.store.books.bookcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.books.bookentity.BookEntity;
import com.book.store.books.bookservice.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getBooks() {
		List<BookEntity> list=bookService.getAllBooks();		
		try {
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);	
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable ("id") int id){
		
		BookEntity bookEntity=null;
		bookEntity=bookService.getBookById(id);
		if (bookEntity==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.of(Optional.of(bookEntity));
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity){
		BookEntity b=null;
		
		try {
			b=this.bookService.addBook(bookEntity);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable ("id") int id) {
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody BookEntity bookEntity, @PathVariable("id") int id){
		
		try {
			this.bookService.updateBook(bookEntity, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}	
	}

}
