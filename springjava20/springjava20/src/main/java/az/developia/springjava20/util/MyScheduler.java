package az.developia.springjava20.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class MyScheduler {

	@Scheduled(fixedDelay = 2000)
	public void m1() {
		System.out.println("2 saniyədən bir");
	}

	@Scheduled(fixedDelay = 5000)
	public void m2() {
		System.out.println("5 saniyədən bir");
	}
}