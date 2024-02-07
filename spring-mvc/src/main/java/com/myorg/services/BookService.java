package com.myorg.services;

import java.util.List;

import com.myorg.entity.Book;

public interface BookService {
	
	public void add(Book book);
	
	public List<Book> getBooks();
	
	public Book getOne(Integer bId);
	
	public void edit(Book book, Integer bId);
	
	public void delete(Integer bId);
}
