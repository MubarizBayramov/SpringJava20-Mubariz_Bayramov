package az.devolopia.SpringJava20_Mubariz_Bayramov.response;

import java.util.List;

import lombok.Data;

@Data
public class StudentListResponse {
	private List<StudentSingleResponse> students;

	public void setStudents(List<StudentSingleResponse> singleResponses) {
		
	}
}