package az.devolopia.SpringJava20_Mubariz_Bayramov.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookFilterRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookFilterRequestForCustomer;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookUpdateRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookSingleResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.service.BookService;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.Constants;
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
		BookAddResponse resp = service.add(req);
		return new ResponseEntity<BookAddResponse>(resp, HttpStatus.CREATED);
	}
	///////////////

	@GetMapping(path = "/search")
	@PreAuthorize(value = "hasAuthority('ROLE_SEARCH_BOOK')")
	public ResponseEntity<BookListResponse> findAllSearch(@RequestParam(name = "query") String query) {

		BookListResponse resp = service.findAllSearch(query);

		return new ResponseEntity<BookListResponse>(resp, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")

	public BookSingleResponse findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody BookUpdateRequest u, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);

		}

		service.update(u);
		return ResponseEntity.ok().build();

	}

	@GetMapping(path = "/begin/{begin}/length/{length}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")

	public ResponseEntity<BookListResponse> findPagination(@PathVariable Integer begin, @PathVariable Integer length) {
		BookListResponse resp = service.findPagination(begin, length);

		return new ResponseEntity<BookListResponse>(resp, HttpStatus.OK);
	}

	@PostMapping(path = "/filter")
	@PreAuthorize(value = "hasAuthority('ROLE_SEARCH_BOOK')")
	public ResponseEntity<BookListResponse> findAllSearchFilter(@RequestBody BookFilterRequest req) {

		BookListResponse resp = service.findAllSearchFilter(req);

		return new ResponseEntity<BookListResponse>(resp, HttpStatus.OK);
	}

	@PostMapping(path = "/filter-for-customer")

	public ResponseEntity<BookListResponse> findAllSearchFilterForCustomer(
			@RequestBody BookFilterRequestForCustomer req) {

		BookListResponse resp = service.findAllSearchFilterForCustomer(req);

		return new ResponseEntity<BookListResponse>(resp, HttpStatus.OK);
	}

}