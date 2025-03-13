package OOP;

public class Sinif1 extends Object {
	private int price;
	private String name;
	private String model;

	public Sinif1(int price, String name, String model) {
		System.out.println("Sinif1 obyekti yaradildi");
		this.price = price;
		this.name = name;
		this.model = model;
	}

	public Sinif1() {

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	protected void m1() {
		System.out.println("sinif1-m1");

	}

}