package az.devolopia.tourist.response;

import java.time.LocalDate;

import lombok.Data;
@Data
public class BookingResponse {
    private Integer bookingId;
    private Integer objectId;
    private Integer touristId;
    private LocalDate startDate;
    private LocalDate endDate;

}

