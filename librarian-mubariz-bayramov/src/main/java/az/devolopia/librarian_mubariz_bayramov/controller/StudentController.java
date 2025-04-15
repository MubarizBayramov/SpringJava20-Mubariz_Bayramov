package az.devolopia.librarian_mubariz_bayramov.controller;

import java.util.List;

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

import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.request.StudentAddRequest;
import az.devolopia.librarian_mubariz_bayramov.request.StudentUpdateRequest;
import az.devolopia.librarian_mubariz_bayramov.response.StudentAddResponse;
import az.devolopia.librarian_mubariz_bayramov.response.StudentSearchResponse;
import az.devolopia.librarian_mubariz_bayramov.service.StudentService;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    @PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
    public ResponseEntity<StudentAddResponse> add(@Valid @RequestBody StudentAddRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        studentService.add(req);
        StudentAddResponse resp = new StudentAddResponse("Student successfully added");
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

  
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }

   
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
    public ResponseEntity<String> update(@PathVariable Integer id, @Valid @RequestBody StudentUpdateRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        studentService.update(id, req);
        return new ResponseEntity<>("Student successfully updated", HttpStatus.OK);
    }

  
    @GetMapping("/search")
    @PreAuthorize(value = "hasAuthority('ROLE_SEARCH_STUDENT')")
    public ResponseEntity<List<StudentSearchResponse>> search(@RequestParam String name) {
        List<StudentSearchResponse> students = studentService.search(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
