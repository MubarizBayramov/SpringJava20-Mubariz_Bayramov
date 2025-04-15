package az.devolopia.librarian_mubariz_bayramov.request;

import lombok.Data;

@Data
public class StudentFilterRequest {
    private String name;
    private String email;
    private Integer minAge;
    private Integer maxAge;
}
