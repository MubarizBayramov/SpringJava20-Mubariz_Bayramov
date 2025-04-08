package az.devolopia.SpringJava20_Mubariz_Bayramov.service;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.UserEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.UserRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.SellerAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.Constants;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private AuthorityService authorityService;

	public void addStudent(StudentAddRequest req, Integer id) {
		UserEntity en = new UserEntity();

		mapper.map(req, en);
		en.setUserId(id);
		en.setUserType("student");
		en.setEnabled(true);

		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);

		en.setPassword("{bcrypt}" + encoded);

		repository.save(en);

	}

	public void checkUsernameExists(String username) {
		Optional<UserEntity> op = repository.findById(username);
		if (op.isPresent()) {
			throw new MyException(Constants.USER_EXISTS_MESSAGE, null, "conflict");
		}

	}
	
	public Integer addSeller(SellerAddRequest req) {

		// check user name existence
		String username = req.getUsername();
		checkUsernameExists(username);

		// add sellers
		Integer id = sellerService.add(req);

		// add users
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);

		en.setPassword("{bcrypt}" + encoded);
		en.setUserType("seller");
		en.setUserId(id);
		if(en.getUserId()!=1111) {
			throw new MyException("nese oldu", null, "");
		}
		repository.save(en);
		// {bcrypt}hfghfhfhfghfghfgh
		// add seller authorities
		authorityService.addSellerAuthorities(username);
		return id;
	}

	public UserEntity findByUsername(String username) {
		Optional<UserEntity> op = repository.findById(username);
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