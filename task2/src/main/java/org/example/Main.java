package org.example;

public class Main {

    public static void main(String[] args) {
       Member[] members = {
               new Human("Гоша", 2, 350),
               new Robot("Кава", 7, 900),
               new Cat("Борис", 4,100),
               new Cat("Зубастик", 3, 100),
               new Cat("Рыжик", 2, 100),
       };
      Challenge[] challenges = {
              new Wall(WallHeight.LOW),
              new Wall(WallHeight.MEDIUM),
              new Wall(WallHeight.HIGH),
              new RunningRoad(RoadLenght.LOW),
              new RunningRoad(RoadLenght.MEDIUM),
              new RunningRoad(RoadLenght.HIGH),
      };
      for(Member m: members) {
          for (Challenge c: challenges) {
              if (!c.challenge(m))
                  break;
          }
      }
    }
}