package az.devolopia.librarian_mubariz_bayramov.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.devolopia.librarian_mubariz_bayramov.entity.AuthorityEntity;
import jakarta.transaction.Transactional;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {

	@Query(value = "insert into authorities (username,authority) select ?1,authority from authority_list where student=1", nativeQuery = true)
	@Modifying
	public void addStudentAuthorities(String username);

	@Modifying
	@Query(value = "insert into authorities (username,authority) select ?1,authority from authority_list where admin=1", nativeQuery = true)
	public void addAdminAuthorities(String username);

	@Modifying
	@Query(value = "insert into authorities (username,authority) select ?1,authority from authority_list where seller=1", nativeQuery = true)
	public void addSellerAuthorities(String username);

}