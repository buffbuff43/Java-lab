package org.example.animals;

public class Cat extends Animal {
    public static int count;
    public Cat(String name, int age, int maxRunDistance, int maxSwimDistance) {
        super(name,"Кот", age, maxRunDistance, 0);
        count++;
    }

}
