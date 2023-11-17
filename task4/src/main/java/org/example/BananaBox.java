package org.example;

import java.util.ArrayList;
import java.util.List;

public class BananaBox implements ComparableFruit {
    private List<Banana>  list = new ArrayList<>();;

    public BananaBox() {

    }

    public List<Banana> getList() {
        return this.list;
    }

    public void add(Banana banana) {
        list.add(banana);
    }

    public float getWeight() {
        float weight = 0;
        for (Banana item : list) {
            weight += item.getWeight();
        }
        return weight;
    }
    void moveTo(BananaBox box) {
        if (box != this) {
            box.getList().addAll(list);
            list.clear();
        }
    }

    public boolean compare(ComparableFruit otherBox) {
        if (otherBox instanceof BananaBox) {
            BananaBox otherBananaBox = (BananaBox) otherBox;
            boolean a = Math.abs(this.getWeight() - otherBananaBox.getWeight()) < 0.0001;
            System.out.println(a);
        }
        return false;
    }

    void printBox() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            for (Banana b : list) {
                System.out.println(b);
            }
        }
    }
}