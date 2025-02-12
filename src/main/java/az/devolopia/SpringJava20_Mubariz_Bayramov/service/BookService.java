package az.devolopia.SpringJava20_Mubariz_Bayramov.service;

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

import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookAdd;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookEntity;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookUpdate;
import az.devolopia.SpringJava20_Mubariz_Bayramov.repository.BookRepository;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookSingleResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.util.MyFileReader;

// IOC
@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private MyFileReader fileReader;

	@Autowired
	private ModelMapper mapper;

	public BookListResponse findAllBooks() {
		List<BookEntity> entities = repository.findAll();

		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();

		for (BookEntity en : entities) {
			BookSingleResponse s = new BookSingleResponse();
			mapper.map(en, s);
			list.add(s);
		}
		BookListResponse resp = new BookListResponse();
		resp.setBooks(list);
		return resp;
	}

	public BookListResponse findAllBooksSearch(String query) {
		
		BookListResponse s = new BookListResponse();
		List<BookEntity> filtered = repository.findAllByNameContaining(query);
		List<BookSingleResponse> list = new ArrayList<BookSingleResponse>();
		
		

		for (BookEntity en : filtered) {
			
			BookSingleResponse se = new BookSingleResponse();
			mapper.map(en, se);
			list.add(se);
		}

		
		s.setBooks(list);
		return s;
	}


	public Integer add(BookAdd book) {
		BookEntity en = new BookEntity();
		mapper.map(book, en);
		repository.save(en);
		return en.getId();

	}

	public void deleteById(Integer id) {

		repository.deleteById(id);
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

	
	public void update(BookUpdate u) {

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

		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

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
}