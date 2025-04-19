package az.devolopia.librarian_mubariz_bayramov.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianBookCountEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.LibrarianBookCountRepo;
import az.devolopia.librarian_mubariz_bayramov.request.LibrarianAddRequest;
import az.devolopia.librarian_mubariz_bayramov.response.LibrarianAddResponse;
import az.devolopia.librarian_mubariz_bayramov.service.UserService;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private LibrarianBookCountRepo librarianBookCountRepo;

	@GetMapping
	public List<LibrarianBookCountEntity> nese() {
		return librarianBookCountRepo.findAll();
	}

	@PostMapping(path = "/librarian")
	public ResponseEntity<LibrarianAddResponse> addLibrarian(@Valid @RequestBody LibrarianAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		LibrarianAddResponse resp = new LibrarianAddResponse();
		Integer id = service.addLibrarian(req);
		resp.setId(id);
		return new ResponseEntity<LibrarianAddResponse>(resp, HttpStatus.CREATED);
	}
}
	
