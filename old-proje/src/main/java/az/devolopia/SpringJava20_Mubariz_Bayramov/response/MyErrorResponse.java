package az.devolopia.SpringJava20_Mubariz_Bayramov.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class MyErrorResponse {
	private List<MyFieldError> validations;
	private String message;
	private LocalDateTime date;
	public void setDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	public void setMessage(Object object) {
		// TODO Auto-generated method stub
		
	}
	public void setValidations(List<MyFieldError> myList) {
		// TODO Auto-generated method stub
		
	}
}