package az.devolopia.SpringJava20_Mubariz_Bayramov.service;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.devolopia.SpringJava20_Mubariz_Bayramov.MyFileReader;
import az.devolopia.SpringJava20_Mubariz_Bayramov.config.MyException;

import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookAdd;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookUpdate;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.BookRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookSingleResponse;


@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private MyFileReader fileReader;

	public List<Book> findAllBooks() {
	@Autowired
	private ModelMapper mapper;

	public BookListResponse findAllBooks() {
		List<BookEntity> entities = repository.findAll();

		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		return repository.findAll();
		for (BookEntity en : entities) {
			BookSingleResponse s = new BookSingleResponse();
			mapper.map(en, s);
			list.add(s);
		}
		BookListResponse resp = new BookListResponse();
		resp.setBooks(list);
		return resp;
	}

	public List<Book> findAllBooksSearch(String query) {
		List<Book> filtered = repository.findAllByNameContaining(query);
	public List<BookEntity> findAllBooksSearch(String query) {
		List<BookEntity> filtered = repository.findAllByNameContaining(query);

		return filtered;
	}

	public Integer add(Book book) {
		repository.save(book);
		return book.getId();
	public Integer add(BookAdd book) {
		BookEntity en = new BookEntity();
		mapper.map(book, en);
		repository.save(en);
		return en.getId();

	}

	public void deleteById(Integer id) {

		repository.deleteById(id);
	}

	public Book findById(Integer id) {
		Optional<Book> o = repository.findById(id);
	public BookSingleResponse findById(Integer id) {// 7
		Optional<BookEntity> o = repository.findById(id);
		BookEntity en = null;
		if (o.isPresent()) {
			return o.get();
			en = o.get();
		} else {
			throw new MyException();
			throw new MyException("kitab taplmadi id=" + id, null, "id-not-found");
		}
		BookSingleResponse resp = new BookSingleResponse();
		mapper.map(en, resp);
		return resp;

	}

	public void update(BookUpdate u) throws Exception {

		Integer id = u.getId();
		Optional<Book> byId = repository.findById(id);
		Optional<BookEntity> byId = repository.findById(id);
		if (!byId.isPresent()) {
			String oxunan = fileReader.readFromFile("id-not-found.txt");

			throw new MyException(oxunan, null, "id-not-found");
		}

		BigDecimal price = u.getPrice();
		String name = u.getName();

		Book book = byId.get();

		book.setPrice(price);
		book.setName(name);
		BookEntity en = byId.get();
		mapper.map(u, en);

		// id null, 0, not found, (id found)
		repository.save(book);
		repository.save(en);

	}

	public BookService() {

		System.out.println("BookService def kons");
	}

	public BookService(int g) {
		System.out.println("BookService int kons");
	}

}



