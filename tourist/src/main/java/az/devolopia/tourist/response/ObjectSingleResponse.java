package az.devolopia.tourist.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectSingleResponse {
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private String address;

    private Integer roomCount;

    private Double area;

    private Integer floor;

    private Integer lessorCode;

    private Integer categoryId;

    private Double pricePerNight;

    private Double averageRating;

    private List<String> comments;
}
