package az.devolopia.librarian_mubariz_bayramov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.repository.AuthorityRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityRepository repository;


	public void addLibrarianAuthorities(String username) {

		repository.addLibrarianAuthorities(username);

	}


	
public void addStudentAuthorities(String username) {
		
		repository.addStudentAuthorities(username);
	}


	public void grantPermission(String username, String string) {
	
		repository.addStudentAuthorities(username);	
	}

}