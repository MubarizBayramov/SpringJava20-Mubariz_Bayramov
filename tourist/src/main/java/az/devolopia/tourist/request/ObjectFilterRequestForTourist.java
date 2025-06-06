package az.devolopia.tourist.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectFilterRequestForTourist {
	
	private Integer categoryId;

	private String name;

	private Integer begin;

	private Integer length;

}
