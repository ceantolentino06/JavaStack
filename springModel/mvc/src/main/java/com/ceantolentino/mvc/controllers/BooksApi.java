package com.ceantolentino.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceantolentino.mvc.models.Book;
import com.ceantolentino.mvc.services.BookService;

@Controller
public class BooksApi {
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
	
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping("/books/{id}")
    public String show_book(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/show.jsp";
    }
    
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
        

    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


    
    
    
    
    
    
    
    
    
//    @RequestMapping("/api/books")
//    public List<Book> index() {
//        return bookService.allBooks();
//    }
//    
//    @RequestMapping(value="/api/books", method=RequestMethod.POST)
//    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = new Book(title, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }
//    
//    @RequestMapping("/api/books/{id}")
//    public Book show(@PathVariable("id") Long id) {
//        Book book = bookService.findBook(id);
//        return book;
//    }
//    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
//        return book;
//    }
//    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//    }
}
