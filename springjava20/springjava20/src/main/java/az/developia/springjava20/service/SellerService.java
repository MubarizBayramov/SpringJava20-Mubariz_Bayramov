package az.developia.springjava20.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springjava20.entity.SellerEntity;
import az.developia.springjava20.repository.SellerRepository;
import az.developia.springjava20.request.SellerAddRequest;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Integer add(SellerAddRequest req) {
		SellerEntity en = new SellerEntity();
		mapper.map(req, en);
		repository.save(en);
		return en.getId();
	}

}