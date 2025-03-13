package az.devolopia.librarian_mubariz_bayramov.service;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.UserEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;
import az.devolopia.librarian_mubariz_bayramov.request.BookAddRequest;
import az.devolopia.librarian_mubariz_bayramov.request.BookUpdateRequest;
import az.devolopia.librarian_mubariz_bayramov.response.BookAddResponse;
import az.devolopia.librarian_mubariz_bayramov.response.BookListResponse;
import az.devolopia.librarian_mubariz_bayramov.response.BookSingleResponse;
import az.devolopia.librarian_mubariz_bayramov.util.MyFileReader;


@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private MyFileReader fileReader;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserService userService;

	public BookAddResponse add(BookAddRequest req) {
		BookEntity en = new BookEntity();
		mapper.map(req, en);
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer LibrarianCode = operator.getUserId();
		en.setLibrarianCode(LibrarianCode);
		repository.save(en);
		BookAddResponse resp = new BookAddResponse();
		resp.setId(en.getId());
		return resp;

	}

	public BookListResponse findAllSearch(String q) {
		BookListResponse s = new BookListResponse();
		List<BookEntity> filtered = repository.findAllByNameContaining(q);
		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		for (BookEntity en : filtered) {
			BookSingleResponse se = new BookSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setBooks(list);
		return s;
	}

	public void deleteById(Integer id) {
		Optional<BookEntity> o = repository.findById(id);

		if (o.isPresent()) {
			 
			String username = userService.findUsername();
			UserEntity operator = userService.findByUsername(username);
			Integer operatorLibrarianCode = operator.getUserId();

			BookEntity bookEntity = o.get();
			Integer bookLibrarianCode = bookEntity.getLibrarianCode();
			if (operatorLibrarianCode == bookLibrarianCode) {
				repository.deleteById(id);
			} else {
				throw new MyException("başqasının kitabıdır", null, "forbidden");
			}
			
			
			
		} else {
			throw new MyException("kitab taplmadı id=" + id, null, "id-not-found");
		}
	}

	public BookSingleResponse findById(Integer id) {// 7
		Optional<BookEntity> o = repository.findById(id);
		BookEntity en = null;
		if (o.isPresent()) {
			en = o.get();
		} else {
			throw new MyException("kitab taplmadi id=" + id, null, "id-not-found");
		}
		BookSingleResponse resp = new BookSingleResponse();
		mapper.map(en, resp);
		return resp;

	}

	public void update(BookUpdateRequest u) {

		Integer id = u.getId();
		Optional<BookEntity> byId = repository.findById(id);
		if (!byId.isPresent()) {
			String oxunan = fileReader.readFromFile("id-not-found.txt");

			throw new MyException(oxunan, null, "id-not-found");
		}
		try {
			/// gdfgdfg
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		BookEntity en = byId.get();
		mapper.map(u, en);

		repository.save(en);

	}

	public BookService() {

		System.out.println("BookService def kons");

		 

	}

	public BookService(int g) {
		System.out.println("BookService int kons");
	}

	public void metod1() throws FileNotFoundException {
		int a = 3;
		int b = 0;
		BufferedReader br = new BufferedReader(new FileReader(""));
		System.out.println(a / b);

	}

	public BookListResponse findPagination(Integer begin, Integer length) {
		BookListResponse s = new BookListResponse();
		List<BookEntity> filtered = repository.findPagination(begin, length);
		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		for (BookEntity en : filtered) {
			BookSingleResponse se = new BookSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setBooks(list);
		return s;
	}
}

