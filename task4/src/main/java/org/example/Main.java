package org.example;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        System.out.println("— Задание №1");
//        Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
//        String[] arrayStr = {"a", "b", "c", "d", "e", "f"};
//        swapElements(arrayInt, 0, 1);
//        swapElements(arrayStr, 0, 1);
//        System.out.println("— Задание №2");
//        convertToList(arrayStr);
//        System.out.println("— Задание №3");
//        Box<Apple> appleBox = new Box<>(new Apple());
//        appleBox.add(1);
//        //appleBox.add(new Lemon()); //нельзя
//        System.out.println("\nСодержимое коробки с яблоками:");
//        appleBox.printBox();
//        Box<Orange> orangeBox = new Box<>(new Orange());
//        orangeBox.add(2);
//        //orangeBox.add(new Apple()); //нельзя
//        System.out.println("\nСодержимое коробки с апельсинами:");
//        orangeBox.printBox();
//        LemonBox<Fruit> lemonBox = new LemonBox<>(new Lemon());
//        lemonBox.add(5);
//        lemonBox.add(new Apple());
//        lemonBox.add(new Orange());
//        LemonBox<Fruit> lemonBox1 = new LemonBox<>(new Lemon());
//        System.out.println("\nСодержимое коробки с лимонами:");
//        lemonBox.printBox();
//        lemonBox.moveTo(lemonBox1);
//        System.out.println("\nСодержимое второй коробки после пересыпки:");
//        lemonBox1.printBox();
//        System.out.println("\nСодержимое первой коробки с лимонами после пересыпки:");
//        lemonBox.printBox();
//        BananaBox bananaBox = new BananaBox();
//        bananaBox.add(new Banana());
//        bananaBox.add(4);
//        System.out.println("\nСодержимое коробки с бананами");
//        bananaBox.printBox();
//        bananaBox.compare(bananaBox);
//        appleBox.compare(bananaBox);// не сравнивается
//        appleBox.compare(lemonBox);
//        orangeBox.compare(appleBox);
//        bananaBox.compare(lemonBox);// не сравнивается
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple());
        appleBox1.add(2);
        appleBox1.add(new Apple());
        appleBox1.printBox();
        LemonBox<Fruit> lemonBox = new LemonBox<>();
        lemonBox.add(new Banana());
        lemonBox.add(new Apple());
        lemonBox.add(new Orange());
        lemonBox.add(new Lemon());
        lemonBox.add(1);
        lemonBox.printBox();
        Box<Orange> orangeBox = new Box<>(new Orange());
        orangeBox.add(2);
        orangeBox.printBox();
        //Попытка пересыпать лимоны в appleBox не сработает
        //lemonBox1.moveTo(appleBox);
    }
        public static void swapElements(Object[] array, int index1, int index2) {
            System.out.println("Исходный массив: " + Arrays.toString(array));
            Object temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
            System.out.println("Итоговый массив: " + Arrays.toString(array) + "\n");
    }

    public static <T> void convertToList(T[] array) {
        System.out.println("Исходный массив: " + Arrays.toString(array));
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Итоговый ArrayList: " + list + "\n");
    }

}