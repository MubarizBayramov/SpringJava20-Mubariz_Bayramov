package Abstraction;

abstract class Animal { // Abstraksiya lazımsız detalları gizlədərək yalnız vacib funksionallığı təqdim edir.
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Hav-hav!");
    }
}