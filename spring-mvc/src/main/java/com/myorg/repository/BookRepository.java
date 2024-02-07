package com.myorg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myorg.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
