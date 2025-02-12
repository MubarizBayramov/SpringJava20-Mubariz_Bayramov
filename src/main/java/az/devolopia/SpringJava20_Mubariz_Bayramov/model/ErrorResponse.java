package az.devolopia.SpringJava20_Mubariz_Bayramov.model;



import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	private List<MyFieldError> validations;
	private String message;
	private LocalDateTime date;
	public void setValidations(List<MyFieldError> myList) {
		
		
	}
}
