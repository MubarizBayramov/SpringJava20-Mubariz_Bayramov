
package az.developia.springjava20.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSingleResponseDetailed extends BookSingleResponse {

	private String sellerName;
	private String sellerEmail;
	private String sellerPhone;

}
