package az.devolopia.librarian_mubariz_bayramov.response;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class MyErrorResponse {
	private List<MyFieldError> validations;
	private String message;
	private LocalDateTime date;
	public void setValidations(List<MyFieldError> myList) {
		// TODO Auto-generated method stub
		
	}
	public void setDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	public void setMessage(String message2) {
		// TODO Auto-generated method stub
		
	}
}