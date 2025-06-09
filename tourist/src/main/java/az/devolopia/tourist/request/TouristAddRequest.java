package az.devolopia.tourist.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TouristAddRequest {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Surname is required")
    private String surname;

    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;

}
