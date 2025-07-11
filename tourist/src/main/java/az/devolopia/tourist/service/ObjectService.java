package az.devolopia.tourist.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.tourist.config.MyConfig;
import az.devolopia.tourist.entity.ObjectEntity;
import az.devolopia.tourist.entity.UserEntity;
import az.devolopia.tourist.exception.MyException;

import az.devolopia.tourist.repository.ObjectRepository;
import az.devolopia.tourist.request.ObjectAddRequest;
import az.devolopia.tourist.request.ObjectFilterRequest;

import az.devolopia.tourist.request.ObjectUpdateRequest;
import az.devolopia.tourist.response.ObjectAddResponse;
import az.devolopia.tourist.response.ObjectListResponse;
import az.devolopia.tourist.response.ObjectSingleResponse;
import az.devolopia.tourist.util.MyFileReader;


@Service
public class ObjectService {

	@Autowired
	private ObjectRepository repository;

	@Autowired
	private MyFileReader fileReader;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserService userService;


	@Autowired
	private MyConfig myConfig;
	

	public ObjectAddResponse add(ObjectAddRequest req) {
		ObjectEntity en = new ObjectEntity();
		mapper.map(req, en);
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer LessorCode = operator.getUserId();
		en.setLessorCode(LessorCode);
		repository.save(en);
		ObjectAddResponse resp = new ObjectAddResponse();
		resp.setId(en.getId());
		return resp;
	}

	
	
	public ObjectListResponse findAllSearch(String q) {
		q = q.toLowerCase();
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorLessorCode = operator.getUserId();
		ObjectListResponse s = new ObjectListResponse();
		List<ObjectEntity> filtered = repository.findMyObjectsSearch(q, operatorLessorCode);
		List<ObjectSingleResponse> list = new ArrayList<ObjectSingleResponse>();
		for (ObjectEntity en : filtered) {
			ObjectSingleResponse se = new ObjectSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setObjects(list);
		return s;
	}

	
	
	public void deleteById(Integer id) {
		Optional<ObjectEntity> o = repository.findById(id);
		if (o.isPresent()) {
			String username = userService.findUsername();
			UserEntity operator = userService.findByUsername(username);
			Integer operatorLessorCode = operator.getUserId();
			ObjectEntity objectEntity = o.get();
			Integer objectLessorCode = objectEntity.getLessorCode();
			if (operatorLessorCode == objectLessorCode) {
				repository.deleteById(id);
			} else {
				throw new MyException("You cannot delete someone else’s property", null, "forbidden");
			}

		} else {
			throw new MyException("Object not found + id=" + id, null, "id-not-found");
		}
	}
	
	

	public ObjectSingleResponse findById(Integer id) {
		Optional<ObjectEntity> o = repository.findById(id);
		ObjectEntity en = null;
		if (o.isPresent()) {
			en = o.get();
		} else {
			throw new MyException("Object not found + id=" + id, null, "id-not-found");
		}
		ObjectSingleResponse resp = new ObjectSingleResponse();
		mapper.map(en, resp);
		return resp;

	}

	
	

	public ObjectListResponse findAllSearchFilter(ObjectFilterRequest r) {
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorLessorCode = operator.getUserId();
		ObjectListResponse s = new ObjectListResponse();
		Long count = repository.findMyObjectsSearchFilterCheck(operatorLessorCode, r.getName(), r.getId(), r.getPrice());
		Integer rowCountLimit = myConfig.getRowCountLimit();
		System.out.println(rowCountLimit);
		if (count > rowCountLimit) {
			throw new MyException("Refine your search. Number of records= " + count + ", maksimum "
					+ rowCountLimit + " ola biler", null, "data-too-long");
		}
		List<ObjectEntity> filtered = repository.findMyObjectsSearchFilter(operatorLessorCode, r.getName(), r.getId(),
				r.getPrice());
		List<ObjectSingleResponse> list = new ArrayList<ObjectSingleResponse>();
		for (ObjectEntity en : filtered) {
			ObjectSingleResponse se = new ObjectSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setObjects(list);
		return s;
	}
	
	
	
	public void update(ObjectUpdateRequest u) {
		Integer id = u.getId();
		Optional<ObjectEntity> byId = repository.findById(id);
		if (!byId.isPresent()) {
			String oxunan = fileReader.readFromFile("id-not-found.txt");
			throw new MyException(oxunan, null, "id-not-found");
		}
		ObjectEntity en = byId.get();
		mapper.map(u, en);
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorLessorCode = operator.getUserId();
		Integer lessorCode = en.getLessorCode();
		if (lessorCode == operatorLessorCode) {
			repository.save(en);
		} else {
			throw new MyException("You cannot edit someone else’s property", null, "forbidden");
		}

	}
	


}
