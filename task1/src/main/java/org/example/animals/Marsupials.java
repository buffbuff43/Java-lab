package org.example.animals;

public abstract class Marsupials extends Animal {
    private static int countMarsupials;
    private String benefit;
    public Marsupials(String name, String type, int age, int maxRunDistance, int maxSwimDistance, String benefit) {
        super(name,type,age, maxRunDistance, maxSwimDistance);
        this.benefit = benefit;
        countMarsupials++;
    }
    public static int getCountMarsupials(){
        return countMarsupials;
    }

    public void getBenefit() {
        System.out.println("Рацион "+getType()+": " + benefit);
        }

    }
