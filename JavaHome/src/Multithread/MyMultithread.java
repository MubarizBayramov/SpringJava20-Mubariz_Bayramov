package Multithread;

public class MyMultithread {
public static void main(String[] args) throws InterruptedException {
	System.out.println("başladıq");
	// isi ikinci MyThread tapsir
	MyThread T1 = new MyThread();
	T1.run(); // ve ya T1.start();
		System.out.println("bitdi");
}
}