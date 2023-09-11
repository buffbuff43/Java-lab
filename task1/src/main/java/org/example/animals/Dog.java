package org.example.animals;

public class Dog extends Animal {
    public static int count;
    private static int maxRunDistance = 500;
    public Dog(String name, int age, int maxSwimDistance) {
        super(name, "Собакен",age, maxRunDistance, maxSwimDistance);
        count++;
    }
}
