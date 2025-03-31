package az.devolopia.librarian_mubariz_bayramov.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.config.MyConfig;
import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.UserEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;
import az.devolopia.librarian_mubariz_bayramov.request.BookAddRequest;
import az.devolopia.librarian_mubariz_bayramov.request.BookFilterRequest;
import az.devolopia.librarian_mubariz_bayramov.request.BookFilterRequestForStudent;
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
	
	@Autowired
	private MyConfig myConfig;

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

	public BookListResponse findAllSearch(String query, Double minPrice, Double maxPrice, String author) {
	    String username = userService.findUsername();
	    UserEntity operator = userService.findByUsername(username);
	    Integer operatorLibrarianCode = operator.getUserId();

	    List<BookEntity> filtered;
	    
	    if (query != null && !query.isEmpty()) {
	        query = query.toLowerCase();
	        filtered = repository.findMyBooksSearch(query, operatorLibrarianCode);
	    } else if (minPrice != null && maxPrice != null) {
	        filtered = repository.findBooksByPriceRange(minPrice, maxPrice, operatorLibrarianCode);
	    } else if (author != null && !author.isEmpty()) {
	        author = author.toLowerCase();
	        filtered = repository.findBooksByAuthor(author, operatorLibrarianCode);
	    } else {
	        filtered = repository.findAllByLibrarianCode(operatorLibrarianCode);
	    }

	    BookListResponse response = new BookListResponse();
	    List<BookSingleResponse> list = new ArrayList<>();
	    
	    for (BookEntity en : filtered) {
	        BookSingleResponse se = new BookSingleResponse();
	        mapper.map(en, se);
	        list.add(se);
	    }
	    
	    response.setBooks(list);
	    return response;
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

	public BookSingleResponse findById(Integer id) {
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
		
		BookEntity en = byId.get();
		
		mapper.map(u, en);
		
		
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorLibrarianCode = operator.getUserId();
		Integer LibrarianCode = en.getLibrarianCode();
		if (LibrarianCode==operatorLibrarianCode) {
			repository.save(en);
		} else { 
			throw new MyException("başqasının kitabını redaktə edə bilməzsiniz", null, "forbidden");
		}
		
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
	
	
	public BookListResponse findAllSearchFilter(BookFilterRequest r) {

	    String username = userService.findUsername();
	    UserEntity operator = userService.findByUsername(username);
	    Integer operatorLibrarianCode = operator.getUserId();

	    BookListResponse s = new BookListResponse();

	    Long count = repository.findMyBooksSearchFilterCheck(operatorLibrarianCode, r.getName(), r.getId(), r.getPriceMin(),
	            r.getPriceMax(), r.getPageCount(), r.getPublishDate(), r.getAuthor(), r.getColor());

	    Integer rowCountLimit = myConfig.getRowCountLimit();
		System.out.println(rowCountLimit);
		if (count > rowCountLimit) {
			throw new MyException("axtraisi deiqlqesdirin, tapilan melumat sayisi = " + count + ", maksimum "
					+ rowCountLimit + " ola iler", null, "data-too-long");
	    }

	    List<BookEntity> filtered = repository.findMyBooksSearchFilter(operatorLibrarianCode, r.getName(), r.getId(),
	            r.getPriceMin(), r.getPriceMax(), r.getPageCount(), r.getPublishDate(), r.getAuthor(), r.getColor());

	    List<BookSingleResponse> list = new ArrayList<>();

	    for (BookEntity en : filtered) {
	        BookSingleResponse se = new BookSingleResponse();
	        mapper.map(en, se);
	        list.add(se);
	    }
	    s.setBooks(list);
	    return s;
	}

	public BookListResponse findAllSearchFilterForStudent(BookFilterRequestForStudent req) {
		
		
		Integer categoryId = req.getCategoryId();
		String category = "";
		if (categoryId != 0) {
			category = String.valueOf(categoryId);
		}

		BookListResponse s = new BookListResponse();

		Integer length = req.getLength();
		if (length > myConfig.getRowCountLimit()) {
			throw new MyException("melumat limiti asildi", null, "data-too-long");
		}
		List<BookEntity> entities = repository.searchFilterCountForStudent(req.getName(), category, req.getBegin(),
				req.getLength());

		Long totalSize = repository.searchFilterCountForStudent(req.getName(), category);

		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		for (BookEntity en : entities) {
			BookSingleResponse se = new BookSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setBooks(list);
		s.setTotalSize(totalSize);

		return s;
	}
		
	}

	


