package az.devolopia.librarian_mubariz_bayramov.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianEntity;
import az.devolopia.librarian_mubariz_bayramov.repository.LibrarianRepository;
import az.devolopia.librarian_mubariz_bayramov.request.LibrarianAddRequest;



@Service
public class LibrarianService {

	@Autowired
	private LibrarianRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Integer add(LibrarianAddRequest req) {
		LibrarianEntity en = new LibrarianEntity();
		mapper.map(req, en);
		repository.save(en);
		return en.getId();
	}

}