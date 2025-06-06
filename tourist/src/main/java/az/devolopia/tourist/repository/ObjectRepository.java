package az.devolopia.tourist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.tourist.entity.ObjectEntity;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Integer> {
	@Query(value = "select * from objects where lessor_code=?2 and lower(name) like %?1%", nativeQuery = true)
	List<ObjectEntity> findMyObjectsSearch(String name, Integer lessorCode);

	// select * from books where limit 3,4
	@Query(value = "select * from books limit ?1,?2", nativeQuery = true)
	List<ObjectEntity> findPagination(Integer begin, Integer length);

	@Query(value = "select count(*) from objects where lessor_code=?1 and lower(name) like %?2% and id like %?3% and price like %?4% and page_count like %?5% and publish_date like %?6%", nativeQuery = true)
	Long findMyObjectsSearchFilterCheck(Integer lessorCode, String name, String id, String price);

	@Query(value = "select * from objects where lessor_code=?1 and lower(name) like %?2% and id like %?3% and price like %?4% and page_count like %?5% and publish_date like %?6%", nativeQuery = true)
	List<ObjectEntity> findMyObjectsSearchFilter(Integer lessorCode, String name, String id, String price);

	@Query(value = "select count(*) from objects where lower(name) like %?1% and category_id like %?2%", nativeQuery = true)
	Long searchFilterCountForTourist(String name, String category);

	@Query(value = "select * from objects where lower(name) like %?1% and category_id like %?2% limit ?3,?4", nativeQuery = true)
	List<ObjectEntity> searchFilterForTourist(String name, String category, Integer begin, Integer length);

}


