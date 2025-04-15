package az.devolopia.librarian_mubariz_bayramov.request;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    @NotNull(message = "ID boş ola bilməz")
    @Positive(message = "ID müsbət olmalıdır")
    private Integer id;

    @NotBlank(message = "Kitabın adı boş ola bilməz")
    private String name;

    @Size(max = 1000, message = "Təsvir maksimum 1000 simvol ola bilər")
    private String description;

    @DecimalMin(value = "0.0", inclusive = false, message = "Qiymət müsbət olmalıdır")
    private BigDecimal price;

    @NotBlank(message = "Müəllif adı boş ola bilməz")
    private String author;

    private String color;

    @Positive(message = "Səhifə sayı müsbət olmalıdır")
    private Integer pageCount;

    @PositiveOrZero(message = "Say sıfır və ya daha çox olmalıdır")
    private Integer quantity;

    @DecimalMin(value = "0.0", inclusive = false, message = "Çəki müsbət olmalıdır")
    private Double weight;

    @Email(message = "Email düzgün formatda deyil")
    private String email;

    @PastOrPresent(message = "Yayımlanma tarixi keçmiş və ya bu gün olmalıdır")
    private LocalDate publishDate;
}

	