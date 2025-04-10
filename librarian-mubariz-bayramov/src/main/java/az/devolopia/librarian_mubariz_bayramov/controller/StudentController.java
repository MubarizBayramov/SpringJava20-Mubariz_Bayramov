package az.devolopia.librarian_mubariz_bayramov.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.request.StudentRequest;
import az.devolopia.librarian_mubariz_bayramov.response.MyErrorResponse;
import az.devolopia.librarian_mubariz_bayramov.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

   
    @PostMapping
    public ResponseEntity<MyErrorResponse> createStudent(@Valid @RequestBody StudentRequest request, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException("Validation error during student creation", br, "VALIDATION");
        }

        studentService.createStudent(request);

        MyErrorResponse response = MyErrorResponse.builder()
                .message("Student successfully created.")
                .date(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Integer id) {
        StudentEntity student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<MyErrorResponse> updateStudent(@PathVariable Integer id,
                                                         @Valid @RequestBody StudentRequest request,
                                                         BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException("Validation error during student update", br, "VALIDATION");
        }

        studentService.updateStudent(id, request);

        MyErrorResponse response = MyErrorResponse.builder()
                .message("Student with ID " + id + " has been updated successfully.")
                .date(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<MyErrorResponse> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);

        MyErrorResponse response = MyErrorResponse.builder()
                .message("Student with ID " + id + " has been deleted successfully.")
                .date(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }
}



