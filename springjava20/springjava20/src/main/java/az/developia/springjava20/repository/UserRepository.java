package az.developia.springjava20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.springjava20.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}