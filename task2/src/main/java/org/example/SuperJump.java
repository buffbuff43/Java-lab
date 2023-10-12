package org.example;

public interface SuperJump {

    default boolean superJump(String name) {
        System.out.println("Кот " + name + " прыгнул суперпрыжком");
        Cat.superJumpCount--;
        return true;
    }

}
