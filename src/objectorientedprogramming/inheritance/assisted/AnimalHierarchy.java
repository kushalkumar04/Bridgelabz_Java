package objectorientedprogramming.inheritence.assisted;
/*
 * AnimalHierarchy Program
 *
 * Demonstrates basic inheritance and method overriding.
 * Animal is the superclass.
 * Dog, Cat, and Bird are subclasses.
 * Each subclass provides its own implementation of makeSound().
 */

class Animal {

    // Common attributes for all animals
    String name;
    int age;

    // Constructor to initialize animal details
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden by subclasses
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Dog class inherits Animal
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    // Overridden method
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Cat class inherits Animal
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    // Overridden method
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

// Bird class inherits Animal
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    // Overridden method
    @Override
    void makeSound() {
        System.out.println("Bird chirps");
    }
}

public class AnimalHierarchy {

    public static void main(String[] args) {

        // Polymorphism: Animal reference holding different subclass objects
        Animal a1 = new Dog("Buddy", 3);
        Animal a2 = new Cat("Kitty", 2);
        Animal a3 = new Bird("Tweety", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}