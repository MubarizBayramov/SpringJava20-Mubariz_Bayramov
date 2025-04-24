package Multithread;

import java.math.BigDecimal;

public class MyThreadArray {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("basladiq");
		Bank akses = new Bank();
		akses.pul = new BigDecimal("10");

		MyThreadClass[] threads = new MyThreadClass[100];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThreadClass(akses);
			threads[i].start();
		}
		Thread.sleep(2000);
		System.out.println(akses.pul);
		System.out.println("bitdi");
	}
}
