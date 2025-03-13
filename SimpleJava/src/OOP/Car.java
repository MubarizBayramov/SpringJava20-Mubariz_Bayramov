package OOP;

public class Car {

	private String brand;
	private double price;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.println("marka = " + brand);
		System.out.println("qiymet = " + price);
	}

	public Car(String brand, double price) {

		this.brand = brand;
		this.price = price;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

}