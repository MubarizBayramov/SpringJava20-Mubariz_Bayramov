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

    @Size(min = 2, max = 50, message = "2-50 simvol aralığında olmalıdır!")
    private String name;

    @NotBlank(message = "Təsvir boş olmamalıdır!")
    private String description;

    @Min(value = 0)
    @Max(value = 1000)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    @Past(message = "Keçmiş tarix olmalıdır")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate publishDate;

    @Size(max = 100)
    private String address;

    private Double area;

    private Integer floor;

 
    private Integer roomCount;

    private Integer lessorCode;

    private Integer categoryId;

    private Double pricePerNight;
}
