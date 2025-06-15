package az.devolopia.tourist.service;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.tourist.entity.UserEntity;
import az.devolopia.tourist.exception.MyException;
import az.devolopia.tourist.repository.UserRepository;
import az.devolopia.tourist.request.LessorAddRequest;
import az.devolopia.tourist.request.TouristAddRequest;
import az.devolopia.tourist.util.Constants;



@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private LessorService lessorService;

	@Autowired
	private TouristService touristService;

	@Autowired
	private AuthorityService authorityService;

	public void checkUsernameExists(String username) {

		Optional<UserEntity> op = repository.findByUsername(username);
		if (op.isPresent()) {
			throw new MyException(Constants.USER_EXISTS_MESSAGE, null, "conflict");
		}

	}

	public Integer addlessor(LessorAddRequest req) {

		// check user name existence
		String username = req.getUsername();
		checkUsernameExists(username);

		// add lessors
		Integer id = lessorService.add(req);

		// add users
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);
		en.setPassword("{bcrypt}" + encoded);
		en.setUserType("lessor");
		en.setUserId(id);
		if (en.getUserId() != 1111) {
			throw new MyException("nese oldu", null, "");
		}
		repository.save(en);
				authorityService.addLessorAuthorities(username);
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

	public Integer addTourist(TouristAddRequest req) {

		// check user name existence
		String username = req.getUsername();
		checkUsernameExists(username);

		// add tourist
			Integer id = touristService.addTourist(req);

		// add users
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);
		en.setPassword("{bcrypt}" + encoded);
		en.setUserType("tourist");
		en.setUserId(id);
		if (en.getUserId() != 1111) {
			throw new MyException("nese oldu", null, "");
		}
		repository.save(en);

		// add lessor authorities
		authorityService.addTouristAuthorities(username);
		return id;
	}

}
