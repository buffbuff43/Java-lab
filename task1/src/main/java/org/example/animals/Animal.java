package org.example.animals;

public abstract class Animal {
    private String name;
    private int age;
    private int maxRunDistance;
    private int maxSwimDistance;
    public static int count;

    private String type;

    public String getType(){
        return type;
    }



    public Animal(String name, String type, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.type = type;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(this.type + " " + this.name + " Пробежал " + dist);
        }
        else
        {
            System.out.println(this.type + " " + this.name + " Не пробежал " + dist);
        }
    }
    public void swim(int swimDist) {
        if (maxSwimDistance == 0) {
            System.out.println(this.type + " " + this.name + " Не умеет плавать");
        }
        else if (maxSwimDistance <= swimDist) {
            System.out.println(this.type + " " + this.name + " Проплыл " + swimDist);
        }
        else
        {
            System.out.println(this.type + " " + this.name + " Не проплыл " + swimDist);
        }
    }
}
