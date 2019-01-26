package com.nikolay.inheritance;

public class AnimalDemo {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Your", 8, 20, 2, 4, 1, 32, "red");

        dog.eat();
        System.out.println("---------------------");

        dog.walk();
        System.out.println("---------------------");

        dog.run();
        System.out.println("---------------------");

    }
}
