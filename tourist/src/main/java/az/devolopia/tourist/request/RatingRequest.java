package az.devolopia.tourist.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingRequest {

    @NotNull(message = "Tourist ID boş ola bilməz")
    private Integer touristId;

    @NotNull(message = "Obyekt ID boş ola bilməz")
    private Integer objectId;

    @NotNull(message = "Qiymət boş ola bilməz")
    @Min(value = 1, message = "Minimum qiymət 1 olmalıdır")
    @Max(value = 10, message = "Maksimum qiymət 10 ola bilər")
    private Integer score;
}
