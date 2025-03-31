package az.devolopia.librarian_mubariz_bayramov.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFilterRequestForStudent {

	private Integer categoryId;

	private String name;

	private Integer begin;

	private Integer length;

}

