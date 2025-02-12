package az.devolopia.SpringJava20_Mubariz_Bayramov.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {
// select * from books where name like %name%
	// s,contains("php"); php
	
	List<BookEntity> findAllByNameContaining(String name);

}





