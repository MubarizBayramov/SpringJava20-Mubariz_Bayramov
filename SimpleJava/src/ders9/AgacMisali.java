package ders9;

public class AgacMisali {

	public static void main(String[] args) {
//		bugun agac ekdik
//		0.5 metr
//		1 litr
//		her litr ucun 20 sm boyuyur
//		her gun evvelki gunun 1.5 defe daha cox su veririk.
//		nece gunnen sonra agac 8 metri kececek.
//
//		2024-12-30 0.5 metr 1 litr ucun 20 sm

		double hundurluk = 0.5;// 1+0.45+0.675 -> 4 gun
		double suHecmi = 1;
		double boyume = 0.2;
		double limitHundurluk = 20;
		int gun = 0;

		while (hundurluk < limitHundurluk) {
			hundurluk += suHecmi * boyume;
			gun++;
			suHecmi *= 1.2;
		}
		System.out.println(gun);// 4

	}

}