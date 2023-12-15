package org.example;

@Table(title = "KANGAROO1")
public class Kangaroo {

    public enum Color {
        ORANGE, BLACK, BROWN;
    }
    public Kangaroo(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    @Column
    private String name;
    public String getName(){
        return name;
    }
    @Column
    private int age;

    @Column
    private String color;

}
