

package az.devolopia.SpringJava20_Mubariz_Bayramov.entity;

import java.time.LocalDateTime;

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

	private String email;

	private String fullName;

	private boolean active = true;

	private LocalDateTime createdAt = LocalDateTime.now();

	private Integer userId;

	private String type;

	private Boolean enabled;

	public void setUserId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void setType(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		
	}

}