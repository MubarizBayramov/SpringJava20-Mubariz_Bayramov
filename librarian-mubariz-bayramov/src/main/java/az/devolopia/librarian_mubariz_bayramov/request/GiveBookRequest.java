package az.devolopia.librarian_mubariz_bayramov.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class GiveBookRequest {
    @NotNull
    private Integer studentId;

    @NotNull
    private Integer bookId;

    @NotNull
    private LocalDate dueDate;
}
