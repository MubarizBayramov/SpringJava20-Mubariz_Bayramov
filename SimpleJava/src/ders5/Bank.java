package ders5;

public class Bank {
	double balance;

	void addMoney(double amount) { // camel case
		balance += amount;
	}

	void drawMoney(double amount) {
		balance -= amount;
	}

}

class MainBank {

	public static void main(String[] args) {
		Bank kapital = new Bank();//

		kapital.addMoney(100);

		Product alma = new Product("Quba almasi", 2.5);
		Product armud = new Product("Dag armudu", 3.2);

		Shopping bravo = new Shopping();
//		bravo=null;
//		bravo=new Shopping();

		bravo.shop(kapital, alma, 5);
		bravo.shop(kapital, armud, 6);
		bravo.shop(kapital, alma, 30);
		System.out.println(kapital.balance); // 4.8

	}

}

class Product {

	String name;// null
	double price;// 0

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}

class Shopping {

	void shop(Bank bank, Product p, double quantity) {
		double total = p.price * quantity;
		if (total > bank.balance) {
			System.out.println("pul yoxdu");
			return;
		}
		bank.drawMoney(total);
	}
}

