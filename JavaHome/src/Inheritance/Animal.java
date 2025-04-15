package Inheritance;

class Animal { //İrsiyyət bir sinfin digər sinifdən xüsusiyyət və metodları miras almasını təmin edir.
    void eat() {
        System.out.println("Heyvan yeyir...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Miyav!");
    }
}