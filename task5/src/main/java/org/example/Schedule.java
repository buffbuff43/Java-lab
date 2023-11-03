package org.example;

import java.util.*;

public class Schedule {
    private LinkedHashMap<String, ArrayList<String>> schedule = new LinkedHashMap<>();

    public void add(String day, String para) {
        ArrayList<String> pars = schedule.getOrDefault(day, new ArrayList<>());



        for(String key : schedule.keySet()){
            ArrayList<String> translations = schedule.get(key);
            if(translations.contains(para)){
                System.out.println(para + " уже была добавлена в " + key);
            }
        }

        pars.add(para);
        schedule.put(day, pars);
    }

    public void get(String day) {
        System.out.print(day + " пары: " + schedule.get(day));
    }

    public void printAll() {
        for ( Map.Entry<String, ArrayList<String>> a : schedule.entrySet()) {
            System.out.println(a);
        }
//        for (String key : schedule.keySet()) {
//            ArrayList<String> translations = schedule.get(key);
//            System.out.println(key + " пары: " + String.join(", ", translations));
//        }
    }
}
