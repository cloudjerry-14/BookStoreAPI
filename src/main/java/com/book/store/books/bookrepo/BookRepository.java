package com.book.store.books.bookrepo;

import org.springframework.data.repository.CrudRepository;

import com.book.store.books.bookentity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer>{
	
	public BookEntity findById(int bId); 

}
