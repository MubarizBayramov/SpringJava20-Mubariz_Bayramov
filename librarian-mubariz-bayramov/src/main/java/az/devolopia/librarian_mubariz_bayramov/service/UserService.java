package az.devolopia.librarian_mubariz_bayramov.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.UserEntity;
import az.devolopia.librarian_mubariz_bayramov.repository.UserRepository;
import az.devolopia.librarian_mubariz_bayramov.request.LibrarianAddRequest;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private LibrarianService librarianService;

	
	

	
	public Integer addLibrarian(LibrarianAddRequest req) {

		
		Integer id = LibrarianService.add(req);

	
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);

		en.setPassword("{bcrypt}" + encoded);
		repository.save(en);
		
	}
}