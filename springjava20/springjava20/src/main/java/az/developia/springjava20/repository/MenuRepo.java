package az.developia.springjava20.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava20.entity.TranslateEntity;

public interface MenuRepo extends JpaRepository<TranslateEntity, Integer> {

	List<TranslateEntity> findAllByLanguage(String language);

}