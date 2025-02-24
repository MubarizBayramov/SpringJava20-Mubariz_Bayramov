package az.devolopia.SpringJava20_Mubariz_Bayramov.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.StudentEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.StudentRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentUpdateRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentSingleResponse;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private ModelMapper mapper;

	public StudentListResponse getAll() {
		List<StudentEntity> students = repository.findAll();
		List<StudentSingleResponse> singleResponses = new ArrayList<StudentSingleResponse>();
		StudentListResponse listResponse = new StudentListResponse();

		for (StudentEntity s : students) {
			StudentSingleResponse sR = new StudentSingleResponse();
			mapper.map(s, sR);
			singleResponses.add(sR);
		}

		listResponse.setStudents(singleResponses);
		return listResponse;
	}

	public StudentAddResponse add(StudentAddRequest req) {

		// check for user name exists
		String username = req.getUsername();
		userService.checkUsernameExists(username);

		// add student data to students tables
		StudentEntity entity = new StudentEntity();
		mapper.map(req, entity);

		repository.save(entity);
		Integer studentId = entity.getId();

		// add student data to users table
		userService.addStudent(req, studentId);

		// add student authorities to authorities table
		authorityService.addStudentAuthorities(req);
		StudentAddResponse resp = new StudentAddResponse();
		resp.setId(entity.getId());
		return resp;
	}

	public StudentListResponse getAllStudents() {
		List<StudentEntity> students = repository.findAll();
		List<StudentSingleResponse> list = new ArrayList<>();
		for (StudentEntity en : students) {
			StudentSingleResponse s = new StudentSingleResponse();
			mapper.map(en, s);
			list.add(s);
		}
		StudentListResponse resp = new StudentListResponse();
		resp.setStudents(list);
		return resp;
	}

	public StudentSingleResponse findStudentById(Integer id) {
		StudentEntity student = repository.findById(id)
				.orElseThrow(() -> new MyException("Student not found", null, "Not found"));
		StudentSingleResponse resp = new StudentSingleResponse();
		mapper.map(student, resp);

		return resp;
	}

	public StudentSingleResponse updateStudent(StudentUpdateRequest studentUpdate) {
		StudentEntity student = repository.findById(studentUpdate.getId())
				.orElseThrow(() -> new MyException("Student not found", null, "Not found"));
		mapper.map(studentUpdate, student);
		repository.save(student);

		StudentSingleResponse resp = new StudentSingleResponse();
		mapper.map(student, resp);
		return resp;
	}

	public void deleteStudent(Integer id) {
		StudentEntity student = repository.findById(id)
				.orElseThrow(() -> new MyException("Student not found", null, "Not found"));
		repository.deleteById(student.getId());
	}
	
	// tələbəni adına əsasən axtaran metod
	public List<StudentEntity> searchStudentsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
	
	// tələbə redaktəsi
	public StudentEntity updateStudent(Integer id, StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudent = repository.findById(id);
        if (existingStudent.isPresent()) {
            StudentEntity student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return repository.save(student);
        }
        return null;
    }
	
}