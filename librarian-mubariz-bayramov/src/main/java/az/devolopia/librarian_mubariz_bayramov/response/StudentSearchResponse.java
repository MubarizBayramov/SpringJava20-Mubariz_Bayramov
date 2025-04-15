package az.devolopia.librarian_mubariz_bayramov.response;


import lombok.Data;

@Data
public class StudentSearchResponse {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private Integer librarianCode;
}
