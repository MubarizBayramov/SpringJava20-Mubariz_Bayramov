package az.developia.springjava20.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFilterRequestForCustomer {

	private Integer categoryId;

	private String name;

	private Integer begin;

	private Integer length;

}