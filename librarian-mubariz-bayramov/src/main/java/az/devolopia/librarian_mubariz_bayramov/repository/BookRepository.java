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


@Query(value = "SELECT COUNT(*) FROM books WHERE librarian_code=?1 AND LOWER(name) LIKE %?2% AND id LIKE %?3% AND (price BETWEEN ?4 AND ?5) AND page_count=?6 AND publish_date LIKE %?7% AND LOWER(author) LIKE %?8% AND LOWER(color) LIKE %?9%", nativeQuery = true)
Long findMyBooksSearchFilterCheck(Integer librarianCode, String name, String id, Double priceMin, Double priceMax, Integer pageCount,
        String publishDate, String author, String color);

@Query(value = "SELECT * FROM books WHERE librarian_code=?1 AND LOWER(name) LIKE %?2% AND id LIKE %?3% AND (price BETWEEN ?4 AND ?5) AND page_count=?6 AND publish_date LIKE %?7% AND LOWER(author) LIKE %?8% AND LOWER(color) LIKE %?9%", nativeQuery = true)
List<BookEntity> findMyBooksSearchFilter(Integer librarianCode, String name, String id, Double priceMin, Double priceMax, Integer pageCount,
        String publishDate, String author, String color);

@Query(value = "select count(*) from books where lower(name) like %?1% and category_id like %?2%", nativeQuery = true)
Long searchFilterCountForStudent(String name, String category);

@Query(value = "select * from books where lower(name) like %?1% and category_id like %?2% limit ?3,?4", nativeQuery = true)
List<BookEntity> searchFilterCountForStudent(String name, String category, Integer begin, Integer length);


}

