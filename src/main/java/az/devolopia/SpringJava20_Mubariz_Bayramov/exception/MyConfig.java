package az.devolopia.SpringJava20_Mubariz_Bayramov.exception

;


import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import az.devolopia.SpringJava20_Mubariz_Bayramov.service.BookService;

@Configuration
public class MyConfig {

	@Bean
	@Primary
	public BookService bookService() {
		BookService b = new BookService(2);

		return b;
	}

	@Bean
	public Mapper mapper() {
		return new Mapper();
	}

}

