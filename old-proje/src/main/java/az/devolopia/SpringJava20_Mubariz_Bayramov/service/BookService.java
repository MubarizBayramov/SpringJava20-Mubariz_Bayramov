package az.devolopia.SpringJava20_Mubariz_Bayramov.service;
import java.awt.print.Book;
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

import az.devolopia.SpringJava20_Mubariz_Bayramov.entity.BookEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.BookRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookAddRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.request.BookUpdateRequest;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookAddResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookSingleResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.MyFileReader;



@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private MyFileReader fileReader;

	@Autowired
	private ModelMapper mapper;

	public BookAddResponse add(BookAddRequest req) {
		BookEntity en = new BookEntity();
		mapper.map(req, en);
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
			repository.deleteById(id);
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

	public void update(BookUpdateRequest u) throws Exception {

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

		try (BufferedReader reader = new BufferedReader(new FileReader("files/input.txt"))) {

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public Book addBook(Book book) {
		
		return null;
	}
}