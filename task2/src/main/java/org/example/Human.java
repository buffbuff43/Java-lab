package org.example;

public class Human implements Member {
    private int maxHeight;
   private int maxLenght;
    String name;

    public Human(String name, int maxHeight, int maxLenght) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }
    @Override
    public boolean run(int distance) {
        if (distance <= maxLenght) {
            System.out.println(this.name + " пробежал " + distance + "м");
            return true;
        }
        else {
            System.out.println(this.name + " не смог пробежать "+ distance + "м и выбывает");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println(this.name+ " перепрыгнул " + height  +"м");
            return  true;
        }
        else {
            System.out.println(this.name+ " не смог перепрыгнуть " + height  +"м и выбывает");
            return false;
        }
    }
}
