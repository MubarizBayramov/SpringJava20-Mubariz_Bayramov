package az.devolopia.librarian_mubariz_bayramov.controller;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.service.BookService;


@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    private BookService bookService;
    
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
    	return bookService.addBook(book);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {   
     	bookService.deleteBook(id);

     	
     	
    }
}