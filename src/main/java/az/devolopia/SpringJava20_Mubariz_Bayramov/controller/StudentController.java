package az.devolopia.SpringJava20_Mubariz_Bayramov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentUpdateRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentSingleResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.service.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public StudentListResponse getAll() {
		return service.getAll();
	}

	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<StudentAddResponse> add(@RequestBody StudentAddRequest add) {
		StudentAddResponse resp = service.add(add);
		return new ResponseEntity<StudentAddResponse>(resp, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public StudentSingleResponse findStudentById(@PathVariable Integer id) {
		return service.findStudentById(id);
	}

	@PutMapping
	public StudentSingleResponse update(@RequestBody StudentUpdateRequest update) {
		return service.updateStudent(update);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteStudent(id);
	}

}