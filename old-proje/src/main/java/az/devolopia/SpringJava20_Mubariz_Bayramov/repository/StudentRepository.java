package az.devolopia.SpringJava20_Mubariz_Bayramov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	
	//tələbəni adına əsasən axtaran
	List<StudentEntity> findByNameContainingIgnoreCase(String name);
 
}



