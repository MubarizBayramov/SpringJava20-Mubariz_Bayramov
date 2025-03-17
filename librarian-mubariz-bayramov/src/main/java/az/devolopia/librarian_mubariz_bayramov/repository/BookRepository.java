package az.devolopia.librarian_mubariz_bayramov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	
	

@Query(value = "SELECT * FROM books WHERE librarian_code = ?2 AND LOWER(name) LIKE %?1%", nativeQuery = true)
List<BookEntity> findMyBooksSearch(String name, Integer librarianCode);

@Query(value = "SELECT * FROM books WHERE librarian_code = ?2 AND price BETWEEN ?1 AND ?2", nativeQuery = true)
List<BookEntity> findBooksByPriceRange(Double minPrice, Double maxPrice, Integer librarianCode);

@Query(value = "SELECT * FROM books WHERE librarian_code = ?2 AND LOWER(author) LIKE %?1%", nativeQuery = true)
List<BookEntity> findBooksByAuthor(String author, Integer librarianCode);

@Query(value = "SELECT * FROM books WHERE librarian_code = ?1", nativeQuery = true)
List<BookEntity> findAllByLibrarianCode(Integer librarianCode);
@Query(value = "select * from books limit ?1,?2", nativeQuery = true)
List<BookEntity> findPagination(Integer begin, Integer length);

}

