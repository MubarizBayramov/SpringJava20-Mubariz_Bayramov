
package az.devolopia.SpringJava20_Mubariz_Bayramov.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.SpringJava20_Mubariz_Bayramov.request.SellerAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.SellerAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.service.UserService;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/seller")
	public ResponseEntity<SellerAddResponse> addSeller(@Valid @RequestBody SellerAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		SellerAddResponse resp = new SellerAddResponse();
		Integer id = service.addSeller(req);
		resp.setId(id);
		return new ResponseEntity<SellerAddResponse>(resp, HttpStatus.CREATED);
	}

	@PostMapping(path = "/customer")
	public ResponseEntity<BookAddResponse> addCustomer(@Valid @RequestBody BookAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		BookAddResponse resp = new BookAddResponse();

		return new ResponseEntity<BookAddResponse>(resp, HttpStatus.CREATED);
	}

}