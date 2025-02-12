package az.devolopia.SpringJava20_Mubariz_Bayramov.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.StudentAdd;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.StudentEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.StudentUpdate;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.StudentRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.StudentSingleResponse;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

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

	public void addStudent(StudentAdd student) {
		StudentEntity entity = new StudentEntity();
		mapper.map(student, entity);
		repository.save(entity);
	}
	
	

	public StudentSingleResponse createStudent(StudentAdd student) {
		StudentEntity newStudent = new StudentEntity();
		mapper.map(student, newStudent);
		repository.save(newStudent);

		StudentSingleResponse studentSingleResponse = new StudentSingleResponse();
		studentSingleResponse.setId(newStudent.getId());
		studentSingleResponse.setName(newStudent.getName());
		studentSingleResponse.setSurname(newStudent.getSurname());
		return studentSingleResponse;

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

	public StudentSingleResponse updateStudent(StudentUpdate studentUpdate) {
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

}
	
	
	
	
	
	
