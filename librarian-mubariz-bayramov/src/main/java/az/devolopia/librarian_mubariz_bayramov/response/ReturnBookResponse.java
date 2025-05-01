package az.devolopia.librarian_mubariz_bayramov.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnBookResponse {
    private String message;
    private LocalDate returnDate;
}

