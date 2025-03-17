package az.devolopia.librarian_mubariz_bayramov.exception;

import org.springframework.validation.BindingResult;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.validation.BindingResult;

@Getter
@Setter
@NoArgsConstructor


public class MyException extends RuntimeException {
    private BindingResult br;
    private String type;

    public MyException(String m, BindingResult br, String type) {
        super(m);
        this.br = br;
        this.type = type;
    }

    // Getter for br
    public BindingResult getBr() {
        return br;
    }

    // Setter for br
    public void setBr(BindingResult br) {
        this.br = br;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }
}
