package az.devolopia.librarian_mubariz_bayramov.service;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;
import az.devolopia.librarian_mubariz_bayramov.request.StudentRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void createStudent(StudentRequest request) {
        StudentEntity student = new StudentEntity();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
        student.setUsername(request.getUsername());
        student.setPassword(request.getPassword());
        student.setPhone(request.getPhone());
        student.setBirthday(request.getBirthday());

        studentRepository.save(student);
    }

    public StudentEntity getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new MyException("Student not found with ID: " + id, null, "NOT_FOUND"));
    }

    public void updateStudent(Integer id, StudentRequest request) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new MyException("Student not found with ID: " + id, null, "NOT_FOUND"));

        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
        student.setUsername(request.getUsername());
        student.setPassword(request.getPassword());
        student.setPhone(request.getPhone());
        student.setBirthday(request.getBirthday());

        studentRepository.save(student);
    }

    public void deleteStudentById(Integer id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new MyException("Student not found with ID: " + id, null, "NOT_FOUND"));

        studentRepository.delete(student);
    }
}


