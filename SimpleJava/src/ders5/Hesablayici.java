package ders5;


public class Hesablayici {

	int topla(int eded1, int eded2) {
		return eded1 + eded2;
	}

	Hesablayici() {

	}

	Hesablayici(int b) {

	}

	public static void main(String[] args) {
		Hesablayici h = new Hesablayici(8);
		int netice1 = h.topla(2, 5); // argument
		int netice2 = h.topla(5, 8);

		System.out.println(netice1);
		System.out.println(netice2);

	}
}

class Masin {

	int qiymet;
	String marka;
	String model;
	int suret;
	double benzin;

	void yolaDus() {
		suret = 20;
		benzin -= 0.5;
	}

	int suretlen(int g) {
		suret += g;
		return suret;
	}

	void dayan() {
		suret = 0;
	}

	Masin(int a) {
		System.out.println("masin sinifinden obyekt yaradildi");
	}

}



class MasinBaslangic {

	public static void main(String[] args) {
		Masin kia = new Masin(5);
		kia.marka = "Kia";
		kia.model = "Sorento";
		kia.qiymet = 10_000;
		kia.benzin = 20;
		kia.yolaDus();
		kia.suretlen(2);
		kia.suretlen(6);
		kia.suretlen(7);
		int s = kia.suretlen(78);
		System.out.println(s);

		Masin ford = new Masin(7);
		ford.qiymet = 20_000;
		ford.model = "Focus";

		TestUcun t = new TestUcun();

	}

}


class SadeEded {
	public static void main(String[] args) {
		int eded = 7;
		boolean sadedir = true;
		for (int i = 2; i <= eded / 2; i++) {
			if (eded % i == 0) {
				sadedir = false;
				break;
			}
		}
		if (sadedir) {
			System.out.println("sadedir");
		} else {
			System.out.println("sade deyil");
		}

	}
}

class nese {

}
