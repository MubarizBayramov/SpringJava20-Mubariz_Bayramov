package az.developia.springjava20.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.developia.springjava20.entity.UserEntity;
import az.developia.springjava20.exception.MyException;
import az.developia.springjava20.repository.UserRepository;
import az.developia.springjava20.request.CustomerAddRequest;
import az.developia.springjava20.request.SellerAddRequest;
import az.developia.springjava20.util.Constants;

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
	private CustomerService customerService;

	@Autowired
	private AuthorityService authorityService;
	
	

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
		if (en.getUserId() != 1111) {
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

	
	
	public Integer addCustomer(CustomerAddRequest req) {

		// check user name existence
		String username = req.getUsername();
		checkUsernameExists(username);

		// add customer
		Integer id = customerService.add(req);

		// add users
		UserEntity en = new UserEntity();
		mapper.map(req, en);
		en.setEnabled(true);
		String pass = en.getPassword();
		String encoded = new BCryptPasswordEncoder().encode(pass);

		en.setPassword("{bcrypt}" + encoded);
		en.setUserType("customer");
		en.setUserId(id);
		if (en.getUserId() != 1111) {
			throw new MyException("nese oldu", null, "");
		}
		repository.save(en);

		// add seller authorities
		authorityService.addCustomerAuthorities(username);
		return id;
	}

}