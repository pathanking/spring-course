package com.myorg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myorg.entity.Book;
import com.myorg.services.BookService;

@Controller
@RequestMapping("/books/v1/api")
public class BookController {

	Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private BookService service;

	@GetMapping
	public String books(Model model) {
		List<Book> books = service.getBooks();
		model.addAttribute("books", books);
		return "list";
	}

	@GetMapping("/showForm")
	public String showBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "add";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		service.add(book);
		return "redirect:/books/v1/api";
	}

	@GetMapping("/edit/{bId}")
	public String showEditForm(@PathVariable Integer bId, Model model) {
		Book book = service.getOne(bId);
		LOGGER.info("{}", book);
		model.addAttribute("book", book);
		return "edit";
	}

	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book book) {
		service.add(book);
		return "redirect:/books/v1/api";
	}

	@GetMapping("/delete/{bId}")
	public String delBook(@PathVariable Integer bId) {
		service.delete(bId);
		return "redirect:/books/v1/api";
		
	}
}
