package az.developia.springjava20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava20.exception.MyException;
import az.developia.springjava20.request.BookAddToBasketRequest;
import az.developia.springjava20.response.BookListResponse;
import az.developia.springjava20.response.CommonAddResponse;
import az.developia.springjava20.service.BasketService;
import az.developia.springjava20.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/book-basket")
public class BasketController {

	@Autowired
	private BasketService service;

	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK_TO_BASKET')")
	public ResponseEntity<CommonAddResponse> add(@Valid @RequestBody BookAddToBasketRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		CommonAddResponse resp = service.add(req);
		return new ResponseEntity<CommonAddResponse>(resp, HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_SEARCH_BOOK')")
	public ResponseEntity<BookListResponse> findAllSearch(@RequestParam(name = "query") String query) {

		return null;
	}

}