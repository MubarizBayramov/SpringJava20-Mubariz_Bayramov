package az.devolopia.tourist.request;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectUpdateRequest {

    @NotNull
    @Positive
    private Integer id;               

    private String name;           

    private String description;      

    private BigDecimal price;        

    private String address;          

    private Integer roomCount;       

    private Double area;           

    private Integer floor;          

    private Integer categoryId;     

    private Double pricePerNight;  
    
}
