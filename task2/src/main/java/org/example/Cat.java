package org.example;

public class Cat implements Member, SuperJump {
    int maxHeight;
    int maxLenght;
    String name;
    public static int superJumpCount = 2;

    public Cat(String name, int maxHeight, int maxLenght) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxLenght) {
            System.out.println("Кот " + this.name + " пробежал " + distance + "м");
            return true;
        } else {
            System.out.println("Кот " + this.name + " не смог пробежать " + distance + "м и выбывает");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Кот " + this.name + " перепрыгнул " + height + "м");
            return true;}
        else if(superJumpCount != 0){
                return superJump(name);
            }
        else {
            System.out.println("Кот " + this.name + " не смог перепрыгнуть " + height + "м и выбывает");
            return false;
        }
    }


}
