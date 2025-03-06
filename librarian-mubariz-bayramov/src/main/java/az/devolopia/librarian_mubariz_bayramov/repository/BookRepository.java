package az.devolopia.librarian_mubariz_bayramov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;



public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	List<BookEntity> findAllByNameContaining(String name);

	// select * from books where limit 3,4
	@Query(value = "select * from books limit ?1,?2", nativeQuery = true)
	List<BookEntity> findPagination(Integer begin, Integer length);

}

