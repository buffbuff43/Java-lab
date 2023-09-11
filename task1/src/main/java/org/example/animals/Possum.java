package org.example.animals;

public class Possum extends Marsupials {
    public static int count;
    public Possum(String name ,int age, int maxRunDistance, int maxSwimDistance, String benefit) {
        super(name,"Опоссум" ,age, maxRunDistance, maxSwimDistance, benefit);
        count++;
    }
}
