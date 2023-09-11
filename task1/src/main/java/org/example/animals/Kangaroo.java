package org.example.animals;

public class Kangaroo extends Marsupials {
    public static int count;
    public Kangaroo(String name, int age, int maxRunDistance, int maxSwimDistance, String benefit) {
        super(name,"Кенгуру" ,age, maxRunDistance, maxSwimDistance, benefit);
        count++;
    }
}
