package org.example.animals;

public class Wombat extends Marsupials {
    public static int count;
    public Wombat(String name, int age, int maxRunDistance, int maxSwimDistance, String benefit) {
        super(name,"Вомбат" ,age, maxRunDistance, maxSwimDistance, benefit);
        count++;
    }
}
