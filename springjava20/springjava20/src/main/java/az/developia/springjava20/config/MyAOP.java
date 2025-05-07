package az.developia.springjava20.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOP {

	@Before(value = "execution(public * az.developia.springjava20.service.UserService.*(..))")
	public void doIt() {
		System.out.println("salam aop");
	}

}