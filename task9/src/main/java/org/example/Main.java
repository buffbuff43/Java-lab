package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Kangaroo[] kangaroos = {
                new Kangaroo("Боксер", 10, "ORANGE"),
                new Kangaroo("Кен", 7, "BROWN"),
                new Kangaroo("Гуру", 19, "BLACK")
        };

        Requests.createTable(Kangaroo.class);

        for(Kangaroo k : kangaroos){
            Requests.insertIntoTable(k);
        }

        Kangaroo1 kangaroo1 = new Kangaroo1("Кенгуру", "11", 10.5);
        Requests.createTable(Kangaroo1.class);
        Requests.insertIntoTable(kangaroo1);

    }
}