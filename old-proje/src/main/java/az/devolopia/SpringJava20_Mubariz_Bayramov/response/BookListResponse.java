package az.devolopia.SpringJava20_Mubariz_Bayramov.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponse {
	
	private List<BookSingleResponse> books;

	public void setBooks(List<BookSingleResponse> list) {
		// TODO Auto-generated method stub
		
	}

}