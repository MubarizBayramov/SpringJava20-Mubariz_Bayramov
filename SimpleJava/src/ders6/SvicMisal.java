package ders6;


public class SvicMisal {
	public static void main(String[] args) {

		int point = 3;
		if (point == 3) {
			System.out.println("kafi");
		} else if (point == 2) {
			System.out.println("pis");
		} else {
			System.out.println("qiymet yoxdur");
		}

		switch (point) { // int String enum char
		case 2: {

			System.out.println("pis");
		}
			break;
		case 3: {

			System.out.println("kafi");
		}
			break;
		default:
			System.out.println("qiymet yoxdur");
		}
	}
}