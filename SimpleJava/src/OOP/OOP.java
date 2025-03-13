package OOP;

public class OOP {

	public static void main(String[] args) {
		Sinif1 s1 = new Sinif1(20, "Kia", "rio");
		Sinif2 s2 = new Sinif2(34, "ford", "mondio", "red", 4444);

		System.out.println(s2.getPrice());
		System.out.println(s2.getName());
		System.out.println(s2.getModel());
		System.out.println(s2.getColor());
		System.out.println(s2.getWeight());
		s2.m1();
	}

}