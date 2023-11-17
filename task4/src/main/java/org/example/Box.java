    package org.example;

    import java.util.*;

        public class Box<T extends Fruit> {
            public Box(T obj){
                list.add(obj);

            }
            public Box(){
            }
            public void add(int count) throws InstantiationException, IllegalAccessException {
                if (list.isEmpty()){
                    System.out.println("Нельзя добавить в пустую коробку неизвестные фрукты");
                    return;
                }
                for (int i = 0; i < count; i++) {
                    try {
                        list.add((T) list.get(0).getClass().newInstance());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
//            public void add(int count) throws InstantiationException, IllegalAccessException {
//                for (int i = 0; i < count; i++) {
//                    T fruit = (T) list.get(0).getClass().newInstance();
//                    list.add(fruit);
//                    System.out.println("Добавлен фрукт в коробку//");
//
//                }
//            }
            public void add(T obj) {
                list.add(obj);
                System.out.println("Добавлен фрукт в коробку/");
            }

//            public void add(Fruit obj) {
//                if (isFruitTypeAllowed((T) obj)) {
//                    list.add((T) obj);
//                    System.out.println("Добавлен фрукт в коробку");
//                } else {
//                    System.out.println("Нельзя добавлять фрукты другого типа в эту коробку.");
//                }
//            }
//
//            private boolean isFruitTypeAllowed(T item) {
//
//                if (list.get(0) instanceof Lemon) {
//                    return true; // Если коробка лимонов, можно добавить любой фрукт
//                } else if (list.get(0) instanceof Orange){
//                    return false;
//                } else if (list.get(0) instanceof Apple) {
//                    return false;
//                }
//                return item.getClass() == list.get(0).getClass();
//            }



            private List<T> list = new ArrayList<>();

            List<T> getList() {
                return list;
            }


            public Box(T... obj) {
                list.addAll(List.of(obj));
            }


            public void moveTo(Box<T> box) {
                if (!box.getList().equals(list)) {
                    if (list.isEmpty()) {
                        System.out.println("Коробка пуста.");
                        return;
                    }

                    if (list.get(0) instanceof Lemon) {
                        List<T> lemons = new ArrayList<>();
                        List<T> apples = new ArrayList<>();

                        for (T fruit : list) {
                            if (fruit instanceof Lemon) {
                                lemons.add(fruit);
                            } else {
                                apples.add(fruit);
                            }
                        }

                        box.getList().addAll(lemons);
                        list.clear();
                        list.addAll(apples); // Возвращаем яблоки в исходную коробку
                        System.out.println("\nЛимоны пересыпаны, остальные фрукты пересыпать нельзя.");
                    } else {
                        System.out.println("Нельзя перемещать фрукты, кроме лимонов, из этой коробки.");
                    }
                }
            }


//        public void moveTo(Box<T> box) {
//            if (!box.getList().equals(list)) {
//                box.getList().addAll(list);
//                list.clear();
//                System.out.println("Пересыпано.");
//            }
//        }

            public float getWeight() {
                if (list.isEmpty()) {
                    return 0;
                }
                float weight = 0;
                for (T l : list) {
                    weight += l.getWeight();
                }
                return weight;
            }

            public void compare(Box<?> otherbox) {
                boolean a = Math.abs(this.getWeight() - otherbox.getWeight()) < 0.0001;
                System.out.println(a);
            }

            public void printBox() {
                if (list.isEmpty()) {
                    System.out.println("Коробка пуста");
                } else {
                    for (T l : list) {
                        System.out.println(l);
                    }
                }
            }
        }