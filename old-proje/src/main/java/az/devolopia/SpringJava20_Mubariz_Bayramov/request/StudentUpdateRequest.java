package az.devolopia.SpringJava20_Mubariz_Bayramov.request;

import lombok.Data;

@Data
public class StudentUpdateRequest {

	private Integer id;
	private String name;
	private String surname;
}