
package az.devolopia.SpringJava20_Mubariz_Bayramov.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String surname;

	private String phone;

	private LocalDate birthday;

	public Integer getId() {
		
		return null;
	}

	public Object getName() {
		
		return null;
	}

	public void setName(Object name2) {
		
		
	}

	public Object getEmail() {
	
		return null;
	}

	public void setEmail(Object email) {
		
		
	}
}