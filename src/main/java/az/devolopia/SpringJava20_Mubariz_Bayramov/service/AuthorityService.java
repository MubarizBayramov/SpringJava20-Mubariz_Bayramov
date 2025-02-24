package az.devolopia.SpringJava20_Mubariz_Bayramov.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.AuthorityRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityRepository repository;

	public void addStudentAuthorities(StudentAddRequest req) {
		String username = req.getUsername();
		repository.addStudentAuthorities(username);

	}
}