package OOP;

public class BMW extends Car {
	// alt ustdur
	// ust altdir
		private String model;
		private String color;

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public void printInfo() {

			System.out.println("model = " + model);
			System.out.println("reng = " + color);
			super.printInfo();
		}

		public BMW(String brand, double price, String model, String color) {
			super(brand, price);
			this.model = model;
			this.color = color;
		}

		public BMW() {
			// TODO Auto-generated constructor stub
		}
	}