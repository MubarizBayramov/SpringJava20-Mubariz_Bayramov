package az.devolopia.tourist.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "objects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private String address;


    private Double area;

    private Integer floor;
    
    
    @Column(name = "room_count")
    private Integer roomCount;

    @Column(name = "lessor_code")
    private Integer lessorCode;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "price_per_night")
    private Double pricePerNight;

    
   



    @OneToMany(mappedBy = "object", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviews;


    public Double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        return reviews.stream()
                .mapToDouble(ReviewEntity::getRating)
                .average()
                .orElse(0.0);
    }

 
    public List<String> getComments() {
        if (reviews == null) return List.of();
        return reviews.stream()
                .map(ReviewEntity::getComment)
                .filter(c -> c != null && !c.isBlank())
                .collect(Collectors.toList());
    }
}
