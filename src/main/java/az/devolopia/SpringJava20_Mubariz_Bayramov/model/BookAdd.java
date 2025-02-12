package az.devolopia.SpringJava20_Mubariz_Bayramov.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAdd {

	@Size(min = 2, message = "min 2 olmalidir")
	@Size(max = 50, message = "max 50 olmalidir")
	private String name;

	@NotBlank(message = "bos qoyma")
	private String description;

	@Min(value = 0, message = "qiymet minimum 0 ola biler")
	@Max(value = 1000, message = "qiymet maksimum 1000 ola biler")
	@Digits(integer = 4, fraction = 2, message = "qiymet 4 tam 2 kesr olar")
	private BigDecimal price;

	@NotNull
	private String author;

	private String color;

	private Integer pageCount;

	private Integer quantity;

	private Double weight;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$", message = "emailin formatini duz yazin gorek")
	private String email;

	@Past(message = "nese")
	private LocalDate publishDate;
}