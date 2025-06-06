package az.devolopia.tourist.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOP {

	@Before(value = "execution(public * az.devolopia.tourist.service.UserService.*(..))")
	public void doIt() {
		System.out.println("salam aop");
	}

}
