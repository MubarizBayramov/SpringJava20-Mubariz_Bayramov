package az.devolopia.librarian_mubariz_bayramov.request;


import lombok.Data;

@Data
public class AuthRequest {
	private String username;
	private String password;
}