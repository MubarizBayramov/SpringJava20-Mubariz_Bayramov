package az.devolopia.librarian_mubariz_bayramov.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	private String username;

	private String password;

	private Integer userId;

	private String userType;

	private Boolean enabled;



	public void setEnabled(boolean b) {
		
	}

	public String getPassword() {
		
		return null;
	}

	public void setPassword(String string) {
		
		
	}

	public Integer getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserType(String string) {
		// TODO Auto-generated method stub
		
	}

}
