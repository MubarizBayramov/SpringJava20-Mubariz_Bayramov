package az.devolopia.librarian_mubariz_bayramov.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponse {
	
	private List<BookSingleResponse> books;

}