package Polymorphism;

public class Animal {  // Çoxformalıq bir metodu fərqli yollarla istifadə etməyə imkan yaradır.
	
	    void makeSound() {
	        System.out.println("Heyvan səs çıxarır...");
	    }
	}

	class Dog extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("Hav-hav!");
	    }
	}

	class Cat extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("Miyav!");
	    }
	}
