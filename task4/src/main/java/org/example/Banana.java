package org.example;

public class Banana extends Fruit implements FruitType {
    private float weight;

    public Banana() {
        super(1.75f);
    }

    public float getWeight() {
        return this.weight;
    }
}