package az.developia.springjava20.response;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponse {

	private List<BookSingleResponse> books;
	private Long totalSize;

}