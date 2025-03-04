package az.devolopia.librarian_mubariz_bayramov.service;



import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;


@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
    
	public Book addBook(Book book) {
		return bookRepository.save(book);
    }
    
  	public void deleteBook(Long id) {
		
	}


	
}

