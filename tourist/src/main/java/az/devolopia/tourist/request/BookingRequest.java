package az.devolopia.tourist.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequest {

    @NotNull(message = "Object ID boş ola bilməz")
    private Integer objectId;

    @NotNull(message = "Turist ID boş ola bilməz")
    private Integer touristId;

    @NotNull(message = "Başlama tarixi boş ola bilməz")
    @FutureOrPresent(message = "Başlama tarixi indiki və ya gələcək tarix olmalıdır")
    private LocalDate startDate;

    @NotNull(message = "Bitmə tarixi boş ola bilməz")
    @FutureOrPresent(message = "Bitmə tarixi indiki və ya gələcək tarix olmalıdır")
    private LocalDate endDate;
    
   
    
}
