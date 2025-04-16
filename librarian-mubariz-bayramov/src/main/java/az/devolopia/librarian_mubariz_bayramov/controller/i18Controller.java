package az.devolopia.librarian_mubariz_bayramov.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.entity.TranslateEntity;
import az.devolopia.librarian_mubariz_bayramov.repository.TranslateRepo;

@RestController
@RequestMapping(path = "/menus")
public class i18Controller {

	@Autowired
	private TranslateRepo repo;

	@GetMapping
	public List<TranslateEntity> getMenu(@RequestHeader(name = "Accept-Language") Locale l) {
		String language = l.getLanguage();
		return repo.findAllByLanguage(language);
	}
}
