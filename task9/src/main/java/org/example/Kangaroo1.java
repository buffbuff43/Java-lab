package org.example;

@Table(title = "KANGARO2")
public class Kangaroo1 {

    public enum Weight {
    }
    public Kangaroo1(String name, String age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    @Column
    private String name;
    public String getName(){
        return name;
    }
    @Column
    private String age;

    @Column
    private double weight;

}
