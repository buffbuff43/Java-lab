package org.example;

public class LemonBox <T extends Fruit> extends Box<T>{
    public LemonBox(Fruit obj){
        super((T)obj);
    }
    public LemonBox(T...obj){
        super(obj);
    }
    public void add(Fruit obj){
        super.add((T)obj);
        System.out.println("Добавлен фрукт в коробку///");
    }
    public void add(int count) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < count; i++) {
            T fruit = null;
            super.add((T) new Lemon());
            System.out.println("Добавлен фрукт в коробку//");

        }

    }
}
