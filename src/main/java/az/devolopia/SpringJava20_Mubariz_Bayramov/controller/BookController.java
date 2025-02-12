package az.devolopia.SpringJava20_Mubariz_Bayramov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookAdd;
import az.devolopia.SpringJava20_Mubariz_Bayramov.model.BookUpdate;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookListResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.response.BookSingleResponse;
import az.devolopia.SpringJava20_Mubariz_Bayramov.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	// dependency injection
	@Autowired
	private BookService service;

	@GetMapping
	public BookListResponse findAllBooks() {

		return service.findAllBooks();
	}
	  
	@GetMapping(path = "/search")
	public BookListResponse findAllBooksSearch(@RequestParam(name = "query") String query) {
		return service.findAllBooksSearch(query);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer add(@Valid @RequestBody BookAdd book, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException("melumatlarin tamligi pozulub", br, "validation");
		}
		return service.add(book);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@GetMapping(path = "/{id}")
	public BookSingleResponse findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PutMapping
	
	public void update(@Valid @RequestBody BookUpdate u, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException("melumatlarin tamligi pozulub", br, "validation");

		}
		
		service.update(u);

	}

}