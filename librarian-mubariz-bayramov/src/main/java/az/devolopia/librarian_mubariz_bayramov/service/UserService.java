package az.devolopia.librarian_mubariz_bayramov.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.librarian_mubariz_bayramov.entity.UserEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.UserRepository;
import az.devolopia.librarian_mubariz_bayramov.request.LibrarianAddRequest;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private LibrarianService LibrarianService;

	@Autowired
	private AuthorityService authorityService;

	

	public void checkUsernameExists(String username) {
		Optional<UserEntity> op = repository.findByUsername(username);		if (op.isPresent()) {
			throw new MyException(Constants.USER_EXISTS_MESSAGE, null, "conflict");
		}

	}

	public Integer addLibrarian(LibrarianAddRequest req) {

		// check user name existence
				String username = req.getUsername();
				checkUsernameExists(username);

		// add Librarians
		Integer id = LibrarianService.add(req);

		// add users
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);

		en.setPassword("{bcrypt}" + encoded);
		en.setUserType("Librarian");
			repository.save(en);
			
		// add Librarian authorities
		authorityService.addLibrarianAuthorities(findUsername());
		return id;
	}

	
	
	public UserEntity findByUsername(String username) {
		Optional<UserEntity> op = repository.findByUsername(username);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new MyException("Bu istifadeci adi tapilmadi", null, "not-found");

		}
	}

	public String findUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}
}