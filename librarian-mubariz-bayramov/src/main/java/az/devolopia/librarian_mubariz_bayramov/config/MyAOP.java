package az.devolopia.librarian_mubariz_bayramov.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOP {

	@Before("execution(public * az.devolopia.librarian_mubariz_bayramov.service.BookService.*(..))")
	public void doIt() {
		System.out.println("salam aop");
	}

}

//AOP deyir ki,az.devolopia.librarian_mubariz_bayramov.service.UserService-dən əvvəl System.out.println("salam aop") kodunu çalışdır 
