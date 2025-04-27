package az.developia.springjava20.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava20.entity.TranslateEntity;
import az.developia.springjava20.repository.MenuRepo;

@RestController
@RequestMapping(path = "/menus")
public class MenuController {

	@Autowired
	private MenuRepo repo;

	@GetMapping
	public List<TranslateEntity> getMenu(@RequestHeader(name = "Accept-Language") Locale l) {
		String language = l.getLanguage();

		return repo.findAllByLanguage(language);
	}
}