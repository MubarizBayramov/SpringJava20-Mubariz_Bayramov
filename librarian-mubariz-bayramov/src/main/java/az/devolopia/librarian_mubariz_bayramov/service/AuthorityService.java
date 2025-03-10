package az.devolopia.librarian_mubariz_bayramov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;
import az.devolopia.librarian_mubariz_bayramov.repository.AuthorityRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityRepository repository;

	public void addStudentAuthorities(StudentAddRequest req) {
		String username = req.getUsername();
		repository.addStudentAuthorities(username);

	}

	public void addLibrarianAuthorities(String username) {

		repository.addLibrarianAuthorities(username);

	}

}