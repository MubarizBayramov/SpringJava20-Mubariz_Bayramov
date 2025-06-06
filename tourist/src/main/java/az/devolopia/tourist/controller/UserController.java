package az.devolopia.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.tourist.exception.MyException;
import az.devolopia.tourist.request.LessorAddRequest;
import az.devolopia.tourist.request.TouristAddRequest;
import az.devolopia.tourist.response.LessorAddResponse;
import az.devolopia.tourist.response.TouristAddResponse;
import az.devolopia.tourist.service.UserService;
import az.devolopia.tourist.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService service;

	
	
	@PostMapping(path = "/lessor")
	public ResponseEntity<LessorAddResponse> addLessor(@Valid @RequestBody LessorAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		LessorAddResponse resp = new LessorAddResponse();
		Integer id = service.addlessor(req);
		resp.setId(id);
		return new ResponseEntity<LessorAddResponse>(resp, HttpStatus.CREATED);
		}
	
	
	
	@PostMapping(path = "/tourist")
	public ResponseEntity<TouristAddResponse> addTourist(@Valid @RequestBody TouristAddRequest req,
			BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		TouristAddResponse resp = new TouristAddResponse();
		Integer id = service.addTourist(req);
		resp.setId(id);
		return new ResponseEntity<TouristAddResponse>(resp, HttpStatus.CREATED);
	}
	}