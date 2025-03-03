package az.devolopia.SpringJava20_Mubariz_Bayramov.request;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentAddRequest {

	private String name;

	private String surname;

	private String phone;

	private LocalDate birthday;

	private String username;

	private String password;

	public String getUsername1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}