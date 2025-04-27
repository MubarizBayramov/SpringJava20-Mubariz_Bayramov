package az.developia.springjava20.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springjava20.config.MyConfig;
import az.developia.springjava20.entity.BookEntity;
import az.developia.springjava20.entity.SellerEntity;
import az.developia.springjava20.entity.UserEntity;
import az.developia.springjava20.exception.MyException;
import az.developia.springjava20.repository.BookRepository;
import az.developia.springjava20.repository.SellerRepository;
import az.developia.springjava20.request.BookAddRequest;
import az.developia.springjava20.request.BookFilterRequest;
import az.developia.springjava20.request.BookFilterRequestForCustomer;
import az.developia.springjava20.request.BookUpdateRequest;
import az.developia.springjava20.response.BookAddResponse;
import az.developia.springjava20.response.BookListResponse;
import az.developia.springjava20.response.BookSingleResponse;
import az.developia.springjava20.response.BookSingleResponseDetailed;
import az.developia.springjava20.util.MyFileReader;

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
	private SellerRepository sellerRepository;

	@Autowired
	private MyConfig myConfig;

	public BookAddResponse add(BookAddRequest req) {
		BookEntity en = new BookEntity();
		mapper.map(req, en);
		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer sellerCode = operator.getUserId();
		en.setSellerCode(sellerCode);
		repository.save(en);
		BookAddResponse resp = new BookAddResponse();
		resp.setId(en.getId());
		return resp;

	}

	public BookListResponse findAllSearch(String q) {
		q = q.toLowerCase();

		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorSellerCode = operator.getUserId();

		BookListResponse s = new BookListResponse();
		List<BookEntity> filtered = repository.findMyBooksSearch(q, operatorSellerCode);
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
			Integer operatorSellerCode = operator.getUserId();

			BookEntity bookEntity = o.get();
			Integer bookSellerCode = bookEntity.getSellerCode();
			if (operatorSellerCode == bookSellerCode) {
				repository.deleteById(id);
			} else {
				throw new MyException("basqasinin kitabini sile bilmezsen", null, "forbidden");
			}

		} else {
			throw new MyException("kitab taplmadi id=" + id, null, "id-not-found");
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

		BookEntity en = byId.get();
		mapper.map(u, en);

		String username = userService.findUsername();
		UserEntity operator = userService.findByUsername(username);
		Integer operatorSellerCode = operator.getUserId();

		Integer sellerCode = en.getSellerCode();
		if (sellerCode == operatorSellerCode) {
			repository.save(en);
		} else {
			throw new MyException("basqasinin kitabini redakte ede bilmezsen", null, "forbidden");
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
		Integer operatorSellerCode = operator.getUserId();

		BookListResponse s = new BookListResponse();
		Long count = repository.findMyBooksSearchFilterCheck(operatorSellerCode, r.getName(), r.getId(), r.getPrice(),
				r.getPageCount(), r.getPublishDate());

		Integer rowCountLimit = myConfig.getRowCountLimit();
		System.out.println(rowCountLimit);
		if (count > rowCountLimit) {
			throw new MyException("axtraisi deiqlqesdirin, tapilan melumat sayisi = " + count + ", maksimum "
					+ rowCountLimit + " ola biler", null, "data-too-long");
		}

		List<BookEntity> filtered = repository.findMyBooksSearchFilter(operatorSellerCode, r.getName(), r.getId(),
				r.getPrice(), r.getPageCount(), r.getPublishDate());

		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		for (BookEntity en : filtered) {
			BookSingleResponse se = new BookSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}
		s.setBooks(list);
		return s;
	}

	public BookListResponse findAllSearchFilterForCustomer(BookFilterRequestForCustomer r) {

		Integer categoryId = r.getCategoryId();
		String category = "";
		if (categoryId != 0) {
			category = String.valueOf(categoryId);
		}

		BookListResponse s = new BookListResponse();

		Integer length = r.getLength();
		if (length > myConfig.getRowCountLimit()) {
			throw new MyException("melumat limiti asildi", null, "data-too-long");
		}
		List<BookEntity> entities = repository.searchFilterForCustomer(r.getName(), category, r.getBegin(),
				r.getLength());

		Long totalSize = repository.searchFilterCountForCustomer(r.getName(), category);

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

	public BookSingleResponseDetailed findByIdDetailed(Integer id) {
		BookSingleResponseDetailed resp = new BookSingleResponseDetailed();

		Optional<BookEntity> o = repository.findById(id);
		BookEntity en = null;
		if (o.isPresent()) {
			en = o.get();
		} else {
			throw new MyException("kitab taplmadi id=" + id, null, "id-not-found");
		}

		mapper.map(en, resp);

		Integer sellerCode = en.getSellerCode();
		SellerEntity s = sellerRepository.findById(sellerCode).get();
		resp.setSellerPhone(s.getPhone());
		resp.setSellerName(s.getName());
		resp.setEmail(s.getEmail());
		return resp;

	}

}