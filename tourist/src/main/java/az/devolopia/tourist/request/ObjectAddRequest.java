package az.devolopia.tourist.request;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectAddRequest  {


	@Size(min = 2, message = "Minimum 2 simvol olmalıdır!")
	@Size(max = 50, message = "Maksimum 50 simvol olmalıdır!")
	private String name;

	@NotBlank(message = "Boş qoymaq olmaz!")
	private String description;

	@Min(value = 0, message = "qiymet minimum 50 ola biler")
	@Max(value = 1000, message = "qiymet maksimum 1000 ola biler")
	@Digits(integer = 4, fraction = 2, message = "qiymet 4 tam 2 kesr olar")
	private BigDecimal price;



	@Past(message = "something")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate publishDate;

}