package org.example;

import org.example.animals.*;

public class Main {
    public static void main(String[] args) {


        Animal[] animals = {
                new Cat("Зося", 5, 200, 0 ),
                new Cat("Бориска", 3, 300, 0 ),
                new Dog("Шарик", 3, 10),
                new Tiger("Барсик", 7, 150, 50),
                new Possum("Вова",  400, 400, 0, "падаль, грызунов, змей, насекомых"),
                new Kangaroo("Михалыч",3, 100, 0, "трава, семена"),
                new Wombat("Комбат", 6, 50, 0, "растения, мхи, грибы, ягоды"),

        };
        for (Animal a : animals) {
            a.run(110);
            a.swim(200);
        }

        System.out.println("\nКоличество котов " + Cat.count);
        System.out.println("Количество собак " + Dog.count);
        System.out.println("Количество тигров " + Tiger.count);
        System.out.println("количество сумчатых " + Marsupials.getCountMarsupials());
        System.out.println("Количество животных " + Animal.getCount());

        System.out.println();
        ((Marsupials) animals[4]).getBenefit();
        ((Marsupials) animals[5]).getBenefit();
        ((Marsupials) animals[6]).getBenefit();

    }
}