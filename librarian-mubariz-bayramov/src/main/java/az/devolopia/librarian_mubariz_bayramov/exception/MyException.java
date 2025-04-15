package az.devolopia.librarian_mubariz_bayramov.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient BindingResult br;
    private final String type;

    public MyException(String message, BindingResult br, String type) {
        super(message);
        this.br = br;
        this.type = type;
    }

    public boolean hasValidationErrors() {
        return br != null && br.hasErrors();
    }
}

