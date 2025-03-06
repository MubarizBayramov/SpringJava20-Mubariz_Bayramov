package az.devolopia.librarian_mubariz_bayramov.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.devolopia.librarian_mubariz_bayramov.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}