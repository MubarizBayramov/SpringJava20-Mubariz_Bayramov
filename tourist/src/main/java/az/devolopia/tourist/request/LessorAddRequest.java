
package az.devolopia.tourist.request;


import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Data
public class LessorAddRequest {
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private String phone;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate birthday;

}