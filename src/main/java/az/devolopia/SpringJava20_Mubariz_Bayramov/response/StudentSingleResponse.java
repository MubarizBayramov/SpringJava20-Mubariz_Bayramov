package az.devolopia.SpringJava20_Mubariz_Bayramov.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentSingleResponse {

	private Integer id;

	private String name;

	private String surname;

}