package az.devolopia.librarian_mubariz_bayramov.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.devolopia.SpringJava20_Mubariz_Bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.response.MyErrorResponse;
import az.devolopia.librarian_mubariz_bayramov.response.MyFieldError;


@RestControllerAdvice
public class MyHandler {
	@ExceptionHandler
	public MyErrorResponse handleMyException(MyException e) {
		MyErrorResponse resp = new MyErrorResponse();
		BindingResult br = e.getBr();
		if (br != null) {
			List<FieldError> fieldErrors = br.getFieldErrors();
			List<MyFieldError> myList = new ArrayList<MyFieldError>();
			for (FieldError error : fieldErrors) {
				MyFieldError myErr = new MyFieldError();
				myErr.setField(error.getField());
				myErr.setMessage(error.getDefaultMessage());
				myList.add(myErr);
			}

			resp.setValidations(myList);

		}
		resp.setDate(LocalDateTime.now());
		resp.setMessage(e.getMessage());
		return resp;

	}

	@ExceptionHandler
	public MyErrorResponse handleAuthorizationDeniedException(AuthorizationDeniedException e) {
		MyErrorResponse resp = new MyErrorResponse();

		resp.setDate(LocalDateTime.now());
		resp.setMessage(e.getMessage());
		return resp;

	}
}