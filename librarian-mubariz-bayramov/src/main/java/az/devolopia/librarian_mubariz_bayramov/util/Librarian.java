package az.devolopia.librarian_mubariz_bayramov.util;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;





@Entity
public class Librarian {
   
    private String username;

    // Getter və Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public static Librarian createLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		return null;
	}

	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}

