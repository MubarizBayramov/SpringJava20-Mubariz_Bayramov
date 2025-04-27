package az.developia.springjava20.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFilterRequest {

	private String id;

	private String name;

	private String price;

	private String pageCount;

	private String publishDate;

}