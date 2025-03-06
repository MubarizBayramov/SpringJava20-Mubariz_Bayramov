package az.devolopia.librarian_mubariz_bayramov.exception;

import org.springframework.validation.BindingResult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MyException extends RuntimeException {
	private BindingResult br;
	private String type;

	public MyException(String m, BindingResult br, String type) {
		super(m);
		this.br = br;
		this.type = type;
	}
}