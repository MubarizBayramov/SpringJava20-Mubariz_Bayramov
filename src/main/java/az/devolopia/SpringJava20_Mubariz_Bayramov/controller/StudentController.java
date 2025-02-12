package az.devolopia.SpringJava20_Mubariz_Bayramov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.SpringJava20_Mubariz_Bayramov.model.StudentAdd;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.StudentUpdate;
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
	public void addStudent(@RequestBody StudentAdd student) {
		service.addStudent(student);
	}
 

	@PostMapping
	public StudentSingleResponse create(@RequestBody StudentAdd add) {
		return service.createStudent(add);
	}

	@GetMapping
	public StudentListResponse findAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/{id}")
	public StudentSingleResponse findStudentById(@PathVariable Integer id) {
		return service.findStudentById(id);
	}

	@PutMapping
	public StudentSingleResponse update(@RequestBody StudentUpdate update) {
		return service.updateStudent(update);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteStudent(id);
	}

}