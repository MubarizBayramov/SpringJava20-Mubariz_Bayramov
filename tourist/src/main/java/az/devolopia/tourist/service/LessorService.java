package az.devolopia.tourist.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.tourist.entity.LessorEntity;
import az.devolopia.tourist.repository.LessorRepository;
import az.devolopia.tourist.request.LessorAddRequest;



@Service
public class LessorService {

	@Autowired
	private LessorRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Integer add(LessorAddRequest req) {
		LessorEntity en = new LessorEntity();
		mapper.map(req, en);
		repository.save(en);
		return en.getId();
	}
}

