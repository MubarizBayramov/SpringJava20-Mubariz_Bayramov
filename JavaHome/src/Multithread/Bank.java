package Multithread;

import java.math.BigDecimal;

public class Bank {
	BigDecimal pul;
	private final Object lock = new Object();

	public void pulCek(BigDecimal miqdar) {
		synchronized (lock) {
			pul = pul.subtract(miqdar);
		}
	}
}
