package az.devolopia.librarian_mubariz_bayramov.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFilterRequest {

    private String id;
    private String name;
    private Double priceMin; // Ən aşağı qiymət
    private Double priceMax; // Ən yüksək qiymət
    private Integer pageCount;
    private String publishDate;
    private String author;
    private String color;

}

