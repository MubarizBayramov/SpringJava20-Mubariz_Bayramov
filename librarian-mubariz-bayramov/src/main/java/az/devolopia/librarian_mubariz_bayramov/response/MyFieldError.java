package az.devolopia.librarian_mubariz_bayramov.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MyFieldError {
	private String field;
	private String message;
	public void setField(String field2) {
		// TODO Auto-generated method stub
		
	}
	public void setMessage(String defaultMessage) {
		// TODO Auto-generated method stub
		
	}
}