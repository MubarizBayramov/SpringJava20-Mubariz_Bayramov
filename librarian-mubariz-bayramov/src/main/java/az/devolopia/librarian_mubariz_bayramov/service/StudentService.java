package az.devolopia.librarian_mubariz_bayramov.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;
import az.devolopia.librarian_mubariz_bayramov.request.StudentAddRequest;
import az.devolopia.librarian_mubariz_bayramov.request.StudentUpdateRequest;
import az.devolopia.librarian_mubariz_bayramov.response.StudentSearchResponse;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper mapper;

    // Add student
    @PostMapping
    public void add(StudentAddRequest req) {
        if (studentRepository.existsByEmail(req.getEmail())) {
            throw new MyException("Student with this email already exists", null, Constants.VALIDATION_TYPE);
        }

        StudentEntity student = mapper.map(req, StudentEntity.class);
        studentRepository.save(student);
        
    }

    // Delete student by ID
    @DeleteMapping(path = "/{id}")
    public void delete(Integer id) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new MyException("Student not found", null, Constants.VALIDATION_TYPE);
        }
        studentRepository.delete(optionalStudent.get());
    }


    // Update student details
    @PutMapping
    public void update(Integer id, StudentUpdateRequest req) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new MyException("Student not found", null, Constants.VALIDATION_TYPE));

        student.setName(req.getName());
        student.setSurname(req.getSurname());
        student.setEmail(req.getEmail());
        student.setAge(req.getAge());
        student.setLibrarianCode(req.getLibrarianCode());

        studentRepository.save(student);
    }

    
 // Search students by name
    @PostMapping
    public List<StudentSearchResponse> search(String name) {
        List<StudentEntity> students = studentRepository.findByNameContainingIgnoreCase(name);

        return students.stream()
                .map(student -> {
                    StudentSearchResponse resp = new StudentSearchResponse();
                    resp.setId(student.getId());
                    resp.setName(student.getName());
                    resp.setSurname(student.getSurname());
                    resp.setEmail(student.getEmail());
                    resp.setAge(student.getAge());
                    resp.setLibrarianCode(student.getLibrarianCode());
                    return resp;
                })
                .toList();
    }

	
    }