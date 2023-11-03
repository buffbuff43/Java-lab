package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("— Задание №1");
        String[] words = {"собака", "университет", "собака", "кот", "слово", "бобер", "кот", "бобер", "рыба", "бобер"};
        HashMap<String, Integer> wordList =  new HashMap<>();
        for (String i : words){
            wordList.put(i, wordList.getOrDefault(i, 0) + 1);
        }
//        for (String k : wordList.keySet()){
//            Integer v = wordList.get(k);
//            System.out.println(k + ": кол-во повторений: " + v);
//        }
        for(var i : wordList.entrySet()){
            System.out.println(i);
        }
        System.out.println("\n— Задание №2");
        Schedule schedule  = new Schedule();
        schedule.add("понедельник","Технологии программирования");
        schedule.add("понедельник","Математика");

        schedule.add("вторник","Алгоритмы");
        schedule.add("среда","Алгоритмы");
        schedule.add("четверг","Оптимизация");
        schedule.add("пятница","Оптимизация");
        schedule.add("пятница","Оптимизация");
        schedule.add("пятница","Оптимизация");
        schedule.add("четверг","Физкультура");



        schedule.printAll();
    }
}