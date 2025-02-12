package az.devolopia.SpringJava20_Mubariz_Bayramov.config;




import org.springframework.validation.BindingResult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private BindingResult br;
	private String type;
	// private String operator;

	public MyException(String m, BindingResult br, String type) {
		super(m);
		this.br = br;
		this.type = type;
	}
}