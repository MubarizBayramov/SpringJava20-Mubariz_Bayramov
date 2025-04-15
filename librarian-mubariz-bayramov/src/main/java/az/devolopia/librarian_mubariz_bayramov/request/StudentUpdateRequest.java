package az.devolopia.librarian_mubariz_bayramov.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentUpdateRequest {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Surname is required")
    private String surname;

    @Email(message = "Invalid email")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    private Integer librarianCode;
}


	