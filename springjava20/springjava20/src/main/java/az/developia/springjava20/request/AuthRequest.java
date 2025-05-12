package az.developia.springjava20.request;
import lombok.Data;

@Data
public class AuthRequest {
	private String username;
	private String password;
}