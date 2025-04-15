package List;

public class Car {
	
		private int price;
		private String model;

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public Car(int price, String model) {
			super();
			this.price = price;
			this.model = model;
		}

		@Override
		public String toString() {
			return "Car [price=" + price + ", model=" + model + "]";
		}

	}


