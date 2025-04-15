package Polymorphism;

public class AnimalObj {
	public static void main(String[] args) {
        Animal myAnimal1 = new Dog();
        Animal myAnimal2 = new Cat();

        myAnimal1.makeSound(); // Hav-hav!
        myAnimal2.makeSound(); // Miyav!
    }
}

