package az.devolopia.librarian_mubariz_bayramov.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentAddRequest {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private String phone;
    private LocalDate birthday;
}