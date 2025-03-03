package az.devolopia.SpringJava20_Mubariz_Bayramov.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "books")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}