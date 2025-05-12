
package az.developia.springjava20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.developia.springjava20.repository.AuthorityRepository;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityRepository repository;

	public void addSellerAuthorities(String username) {

		repository.addSellerAuthorities(username);

	}

	public void addCustomerAuthorities(String username) {

		repository.addCustomerAuthorities(username);

	}

}
