package az.devolopia.SpringJava20_Mubariz_Bayramov.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

	@NotNull
	@Positive
	private Integer id;

	private String name;

	private String description;

	private BigDecimal price;

	private String author;

	private String color;

	private Integer pageCount;

	private Integer quantity;

	private Double weight;

	private String email;

	private LocalDate publishDate;

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}