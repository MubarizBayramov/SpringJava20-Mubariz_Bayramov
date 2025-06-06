package az.devolopia.tourist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.tourist.repository.AuthorityRepository;



@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityRepository repository;
	public void addLessorAuthorities(String username) {
		repository.addLessorAuthorities(username);
	}

	
	public void addTouristAuthorities(String username) {
		repository.addTouristAuthorities(username);

	}

}