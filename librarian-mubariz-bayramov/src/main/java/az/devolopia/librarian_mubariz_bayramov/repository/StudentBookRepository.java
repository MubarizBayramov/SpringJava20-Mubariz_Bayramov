package az.devolopia.librarian_mubariz_bayramov.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;

public interface StudentBookRepository extends JpaRepository<StudentBookEntity, Integer> {
 
	
	boolean existsByBookIdAndStudentIdAndReturnedFalse(Integer bookId, Integer studentId);

	@Query("""
		    SELECT s FROM StudentBookEntity s
		    WHERE s.returned = true AND s.bookId IN (
		        SELECT b.id FROM BookEntity b WHERE b.librarianCode = :librarianCode
		    )
		""")
		List<StudentBookEntity> findAllReturnedBooksByLibrarianCode(@Param("librarianCode") Integer librarianCode);

	@Query("""
		    SELECT s FROM StudentBookEntity s
		    WHERE s.returned = false
		    AND s.dueDate < :today
		    AND s.bookId IN (
		        SELECT b.id FROM BookEntity b WHERE b.librarianCode = :librarianCode
		    )
		""")
		List<StudentBookEntity> findAllDelayedBooksByLibrarianCodeAndNotReturned(
		        @Param("librarianCode") Integer librarianCode, 
		        @Param("today") LocalDate today);

}

