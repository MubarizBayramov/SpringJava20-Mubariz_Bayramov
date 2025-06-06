package az.devolopia.tourist.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.tourist.entity.TouristEntity;
import az.devolopia.tourist.repository.TouristRepository;
import az.devolopia.tourist.request.TouristAddRequest;

@Service
public class TouristService {
	@Autowired
	private TouristRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Integer add(TouristAddRequest req) {
		TouristEntity en = new TouristEntity();
		mapper.map(req, en);
		repository.save(en);
		return en.getId();
	}


}
