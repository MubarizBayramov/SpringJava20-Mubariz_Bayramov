package az.devolopia.librarian_mubariz_bayramov.service;



import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;
import az.devolopia.librarian_mubariz_bayramov.request.BookAddRequest;
import jakarta.validation.Valid;


@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
   
    
  	public void deleteBook(Long id) {
		
	}

	public void add(@Valid BookAddRequest req) {
		// TODO Auto-generated method stub
		
	}


	
}

