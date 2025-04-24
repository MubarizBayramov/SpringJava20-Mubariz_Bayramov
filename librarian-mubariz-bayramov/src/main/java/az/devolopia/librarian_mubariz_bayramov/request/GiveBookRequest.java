package az.devolopia.librarian_mubariz_bayramov.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GiveBookRequest {
    @NotNull
    private Integer studentId;

    @NotNull
    private Integer bookId;

    @NotNull
    private Integer librarianId;
}

