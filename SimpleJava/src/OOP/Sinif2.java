package OOP;

public class Sinif2 extends Sinif1 {

	private String color;
	private double weight;

	public Sinif2(int price, String name, String model, String color, double weight) {
		super(price, name, model);

		System.out.println("Sinif2 obyekti yaradildi");
		super.setName("hunday");

		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public void m1() {
		System.out.println("sinif2-m1");

	}
}