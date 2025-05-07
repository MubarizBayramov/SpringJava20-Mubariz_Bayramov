package az.devolopia.librarian_mubariz_bayramov.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	private String jwt;
	private String refreshToken;
}