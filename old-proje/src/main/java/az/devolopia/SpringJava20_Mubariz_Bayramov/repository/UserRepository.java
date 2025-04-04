package az.devolopia.SpringJava20_Mubariz_Bayramov.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


	Optional<UserEntity> findByUsername(String username);

	Optional<UserEntity> findByEmail(String email);
}