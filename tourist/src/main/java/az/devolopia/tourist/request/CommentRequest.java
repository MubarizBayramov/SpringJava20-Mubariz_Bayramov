package az.devolopia.tourist.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {

    @NotNull(message = "Tourist ID boş ola bilməz")
    private Integer touristId;

    @NotNull(message = "Obyekt ID boş ola bilməz")
    private Integer objectId;

    @NotBlank(message = "Şərh boş ola bilməz")
    private String content;
}
