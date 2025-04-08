package az.devolopia.SpringJava20_Mubariz_Bayramov.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SellerAddRequest {
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private String phone;
	private LocalDate birthday;

}