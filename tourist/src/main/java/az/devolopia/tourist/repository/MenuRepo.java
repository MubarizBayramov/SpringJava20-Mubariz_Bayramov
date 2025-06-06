package az.devolopia.tourist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.tourist.entity.TranslateEntity;


public interface MenuRepo extends JpaRepository<TranslateEntity, Integer> {

	List<TranslateEntity> findAllByLanguage(String language);

}
