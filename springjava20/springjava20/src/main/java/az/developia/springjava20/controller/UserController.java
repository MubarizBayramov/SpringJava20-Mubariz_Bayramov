package az.developia.springjava20.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava20.entity.SellerBookCountEntity;
import az.developia.springjava20.exception.MyException;
import az.developia.springjava20.repository.SellerBookCountRepo;
import az.developia.springjava20.request.CustomerAddRequest;
import az.developia.springjava20.request.SellerAddRequest;
import az.developia.springjava20.response.CustomerAddResponse;
import az.developia.springjava20.response.SellerAddResponse;
import az.developia.springjava20.service.UserService;
import az.developia.springjava20.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private SellerBookCountRepo sellerBookCountRepo;

	@GetMapping
	public List<SellerBookCountEntity> nese() {
		return sellerBookCountRepo.findAll();
	}

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
	public ResponseEntity<CustomerAddResponse> addCustomer(@Valid @RequestBody CustomerAddRequest req,
			BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		CustomerAddResponse resp = new CustomerAddResponse();

		Integer id = service.addCustomer(req);
		resp.setId(id);

		return new ResponseEntity<CustomerAddResponse>(resp, HttpStatus.CREATED);
	}

}