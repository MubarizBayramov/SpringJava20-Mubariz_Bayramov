package az.devolopia.SpringJava20_Mubariz_Bayramov.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.SellerEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.SellerRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.SellerAddRequest;

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