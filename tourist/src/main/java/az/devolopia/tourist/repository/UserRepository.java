package az.devolopia.tourist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.tourist.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);
}