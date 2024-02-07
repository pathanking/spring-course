package com.myorg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myorg.entity.Book;
import com.myorg.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository repo;

	public BookServiceImpl(BookRepository repo) {
		this.repo = repo;
	}

	@Override
	public void add(Book book) {
		repo.save(book);
	}

	@Override
	public Book getOne(Integer bId) {
		return repo.findById(bId).get();
	}

	@Override
	public void edit(Book book, Integer bId) {

	}

	@Override
	public void delete(Integer bId) {
		Book book = getOne(bId);
		repo.delete(book);
	}

	@Override
	public List<Book> getBooks() {
		return repo.findAll();
	}

}
