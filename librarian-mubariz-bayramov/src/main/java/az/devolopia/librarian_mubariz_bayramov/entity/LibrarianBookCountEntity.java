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
@Table(name = "librarians_book_count")
public class LibrarianBookCountEntity {
	
	
	@Id
	private Integer id;
	private String name;
	private Integer count;

}


