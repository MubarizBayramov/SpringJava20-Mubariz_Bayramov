package az.developia.springjava20.entity;

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
@Table(name = "sellers_book_count")
public class SellerBookCountEntity {

	@Id
	private Integer id;
	private String name;
	private Integer count;

}