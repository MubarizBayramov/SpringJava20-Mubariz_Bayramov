package az.devolopia.SpringJava20_Mubariz_Bayramov.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.UserEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.UserRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.StudentAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.Constants;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	public void addStudent(StudentAddRequest req, Integer id) {
		UserEntity en = new UserEntity();

		mapper.map(req, en);
		en.setUserId(id);
		en.setType("student");
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
}