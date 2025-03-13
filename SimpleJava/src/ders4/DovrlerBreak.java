package ders4;


public class DovrlerBreak {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}

	}

}



class DovrlerDoWhile2 {

	public static void main1(String[] args) {
		int bizim = 1;
		do {
			System.out.println(bizim);
		} while (bizim <= 10);

	}

}


class DovrlerFor {

	public static void main(String[] args) {

		for (int a = 1; a <= 10; a++) { // a=3
			for (int b = 1; b <= 10; b++) {// b=10
				System.out.println(a + " * " + b + " = " + (a * b));

			}
			System.out.println("----------------");

		}
		System.out.println("for bitdi");
	}

}

class DovrlerFor2 {

	public static void main(String[] args) {
		int a = 1;
		for (; a <= 10;) { // a=3
			for (int b = 1; b <= 10; b++) {// b=10
				System.out.println(a + " * " + b + " = " + (a * b));

			}
			System.out.println("----------------");

		}
		System.out.println("for bitdi");
	}

}

class DovrlerWhile {

	public static void main(String[] args) {
		int a = 1;

		while (a <= 10) { // a=3
			int b = 1;
			while (b <= 10) {// b=10
				System.out.println(a + " * " + b + " = " + (a * b));
				b++;
			}
			System.out.println("----------------");

			a++;
		}
		System.out.println("for bitdi");
	}

}

class Test4 {

	public static void main(String[] args) {
		int age = 19;
		boolean hasHome = true;
		if (age >= 18 && !hasHome) {

			System.out.println("buyur 06");
		} else {
			System.out.println("velo");
		}
		System.out.println(hasHome);
	}

}

class Test6Ternary {

	public static void main(String[] args) {
		int age = 20;
		String message = age >= 18 ? "uniye olar" : "olmaz";
		System.out.println(message);
	}

}