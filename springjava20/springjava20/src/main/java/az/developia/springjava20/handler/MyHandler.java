package az.developia.springjava20.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava20.exception.MyException;
import az.developia.springjava20.response.MyErrorResponse;
import az.developia.springjava20.response.MyFieldError;

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