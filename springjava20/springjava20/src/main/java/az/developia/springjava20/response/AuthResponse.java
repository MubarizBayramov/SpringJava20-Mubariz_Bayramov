package az.developia.springjava20.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	private String jwt;
	private String refreshToken;
}