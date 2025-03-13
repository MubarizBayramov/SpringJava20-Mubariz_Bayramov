package ders8;

import java.util.Arrays;
import java.util.Random;

public class massiv {
	public static void main(String[] args) {
		Random r = new Random();
		int[] massivim = new int[20];
		for (int i = 0; i < massivim.length; i++) {
			massivim[i] = r.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(massivim));
		for (int i : massivim) {
			if (sadedirmi(i)) {
				System.out.println(i);
			}
		}

	}

	static boolean sadedirmi(int i) {
		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

}

class MainMassivler {

	public static void main(String[] args) {
		// massivler
		// int[] ededler = new int[10]; // 0 - 9
		// System.out.println(ededler[3]);
		// ededler[0] = 2;
		// ededler[1] = 6;
		// ededler[2] = 123;
		// String[] adlar = new String[200];
		// adlar[3] = "Hesen";
		// System.out.println(adlar[3]);

//		int[] a = new int[5];
//		a[0] = 4;
//		a[1] = 22;
//		a[2] = 67;
//		a[3] = 8;
//		a[4] = 9;
		int[] a = { 4, 22, 77, 887, 7676 };
		int uzunluq = a.length;
		for (int i = 0; i < uzunluq; i++) {
			System.out.println(a[i]);
		}

		// for each
		for (int i : a) {
			System.out.println(i);
		}

	}

}


class MainMassivler2 {

	public static void main(String[] args) {
		// element sayi
		int[] massiv1 = { 14, 1, 12, 9, 5 }; // 1 olculu massiv
		int[] massiv2 = { 6, 23, 8 };
		int[] massiv3 = { 18, 5, 12 };

		// 2 olculu
		int[][] massiv4 = { massiv1, massiv2, massiv3 };

	}

}

class MainMassivler3 {

	public static void main(String[] args) {
		int cem = neseOlaBiler(2, 5, 9, 3, 1);
		System.out.println(cem);
		int[] massiv = { 5, 7, 1, 9 };
		// Arrays.fill(massiv, 33);
		System.out.println(Arrays.toString(massiv));
	}

	static int neseOlaBiler(int... massivimiz) {

		int cemimiz = 0;
		for (int i : massivimiz) {
			cemimiz += i;
		}
		return cemimiz;
	}

}