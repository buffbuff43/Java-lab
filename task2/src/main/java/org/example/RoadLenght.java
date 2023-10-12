package org.example;

public enum RoadLenght {
    LOW("Короткая", 100), MEDIUM("Средняя", 300), HIGH("Длинная", 500);
    private String title;
    private  int lenght;
    RoadLenght(String title, int lenght) {
        this.title = title;
        this.lenght = lenght;
    }

    public String getTitle() {
        return title;
    }

    public int getLenght() {
        return lenght;
    }
}