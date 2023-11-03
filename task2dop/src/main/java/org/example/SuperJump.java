package org.example;

public interface SuperJump {

    default boolean superJump(String name) {
        System.out.println(name + " прыгнул суперпрыжком");
        Human.superJumpCount--;
        return true;
    }

}
