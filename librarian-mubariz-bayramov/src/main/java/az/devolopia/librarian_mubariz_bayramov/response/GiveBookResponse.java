package az.devolopia.librarian_mubariz_bayramov.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiveBookResponse {
    private String message;
    private LocalDate givenDate;
    private LocalDate dueDate;
}
