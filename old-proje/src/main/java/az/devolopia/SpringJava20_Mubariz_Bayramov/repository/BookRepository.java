package az.devolopia.SpringJava20_Mubariz_Bayramov.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	@Query(value = "select * from books where seller_code=?2 and lower(name) like %?1%", nativeQuery = true)
	List<BookEntity> findMyBooksSearch(String name, Integer sellerCode);

	// select * from books where limit 3,4
	@Query(value = "select * from books limit ?1,?2", nativeQuery = true)
	List<BookEntity> findPagination(Integer begin, Integer length);

	@Query(value = "select count(*) from books where seller_code=?1 and lower(name) like %?2% and id like %?3% and price like %?4% and page_count like %?5% and publish_date like %?6%", nativeQuery = true)
	Long findMyBooksSearchFilterCheck(Integer sellerCode, String name, String id, String price, String pageCount,
			String publishDate);

	@Query(value = "select * from books where seller_code=?1 and lower(name) like %?2% and id like %?3% and price like %?4% and page_count like %?5% and publish_date like %?6%", nativeQuery = true)
	List<BookEntity> findMyBooksSearchFilter(Integer sellerCode, String name, String id, String price, String pageCount,
			String publishDate);

	@Query(value = "select count(*) from books where lower(name) like %?1% and category_id like %?2%", nativeQuery = true)
	Long searchFilterCountForCustomer(String name, String category);

	@Query(value = "select * from books where lower(name) like %?1% and category_id like %?2% limit ?3,?4", nativeQuery = true)
	List<BookEntity> searchFilterForCustomer(String name, String category, Integer begin, Integer length);

}


