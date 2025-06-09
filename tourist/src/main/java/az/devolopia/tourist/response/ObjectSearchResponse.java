package az.devolopia.tourist.response;

import lombok.Data;

@Data
public class ObjectSearchResponse {
    private Integer id;
    private String name;
    private String address;
    private Double pricePerNight;
    private Double avgRating;
    private Integer commentCount;
}
