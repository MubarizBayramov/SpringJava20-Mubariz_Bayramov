package ders6;

import java.util.Random;

public class Tesadufi {

	public static void main(String[] args) {
		Random r = new Random();
		int z1 = 0; // 1 : 6
		int z2 = 0; // 1 : 6

		boolean qosaDusmedi = true;
		int saygac = 0;
		while (qosaDusmedi) {
			z1 = r.nextInt(6) + 1; // 1 : 6
			z2 = r.nextInt(6) + 1; // 1 : 6

			System.out.println(z1 + ":" + z2);
			saygac++;
			System.out.println("saygac = " + saygac);

			if (z1 == 6 && z2 == 6) {
				qosaDusmedi = false;

			}
		}
	}

}