package az.devolopia.librarian_mubariz_bayramov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.entity.TranslateEntity;

	public interface TranslateRepo extends JpaRepository<TranslateEntity, Integer> {

		List<TranslateEntity> findAllByLanguage(String language);

	}

