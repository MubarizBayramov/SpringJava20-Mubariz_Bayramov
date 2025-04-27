package az.developia.springjava20.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springjava20.entity.CustomerEntity;
import az.developia.springjava20.repository.CustomerRepository;
import az.developia.springjava20.request.CustomerAddRequest;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Integer add(CustomerAddRequest req) {
		CustomerEntity en = new CustomerEntity();
		mapper.map(req, en);
		repository.save(en);
		return en.getId();
	}

}