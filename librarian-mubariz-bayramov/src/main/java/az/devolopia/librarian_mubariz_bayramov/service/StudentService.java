package az.devolopia.librarian_mubariz_bayramov.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;
import az.devolopia.librarian_mubariz_bayramov.request.StudentAddRequest;
import lombok.Data;

@Data
@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AuthorityService authorityService;
    
    public Integer addStudent(StudentAddRequest req) {
        // Check if username already exists
        Optional<StudentEntity> existingStudent = repository.findByUsername(req.getUsername());
        if (existingStudent.isPresent()) {
            throw new MyException("Bu username artıq istifadə olunub!", null, "conflict");
        }
        
        // Add student
        StudentEntity student = new StudentEntity();
        mapper.map(req, student);
        student.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(req.getPassword()));
        repository.save(student);
        
        // Assign default authority to search books
        authorityService.addStudentAuthorities(student.getUsername());
        authorityService.grantPermission(student.getUsername(), "BOOK_SEARCH");
        
        return student.getId();
    }
    
    public StudentEntity findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new MyException("Bu istifadəçi tapılmadı", null, "not-found"));
    }
}