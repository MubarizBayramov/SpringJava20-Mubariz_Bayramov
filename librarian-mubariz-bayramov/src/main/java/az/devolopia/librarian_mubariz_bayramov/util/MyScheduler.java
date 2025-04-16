package az.devolopia.librarian_mubariz_bayramov.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class MyScheduler {
@Scheduled(fixedDelay = 2000)

public void m1() {
	System.out.println("Bu metod hər 2 saniyədən bir işləyir");
	}
	
	@Scheduled(fixedDelay = 5000)  //bu cür yazılış 5 saniyə deməkdir

	public void m2() {
		System.out.println("Bu metod hər 5 saniyədən bir işləyir");
}

}
