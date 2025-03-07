package az.devolopia.librarian_mubariz_bayramov.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookAddResponse;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.request.BookAddRequest;
import az.devolopia.librarian_mubariz_bayramov.service.BookService;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public ResponseEntity<BookAddResponse> add(@Valid @RequestBody BookAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		BookAddResponse resp = new BookAddResponse();
		service.add(req);
		return new ResponseEntity<BookAddResponse>(resp, HttpStatus.CREATED);
	}
	}