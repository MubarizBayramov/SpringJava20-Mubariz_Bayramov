package Multithread;

import java.math.BigDecimal;

public class MyThreadClass extends Thread {

	Bank bank;

	public MyThreadClass(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		bank.pulCek(new BigDecimal("0.1"));
	}
}
