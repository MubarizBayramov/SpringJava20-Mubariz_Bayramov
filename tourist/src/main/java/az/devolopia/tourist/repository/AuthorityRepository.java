package az.devolopia.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.tourist.entity.AuthorityEntity;
import jakarta.transaction.Transactional;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {

	@Modifying
	@Query(value = "insert into authorities (username,authority) select ?1,authority from authority_list where lessor=1", nativeQuery = true)
	public void addLessorAuthorities(String username);

	@Modifying
	@Query(value = "insert into authorities (username,authority) select ?1,authority from authority_list where tourist=1", nativeQuery = true)
	public void addTouristAuthorities(String username);

}