package az.developia.springjava20.service;

import org.springframework.stereotype.Service;

import az.developia.springjava20.request.BookAddToBasketRequest;
import az.developia.springjava20.response.CommonAddResponse;
import jakarta.validation.Valid;

@Service
public class BasketService {

	public CommonAddResponse add(@Valid BookAddToBasketRequest req) {
		
		return null;
	}

}