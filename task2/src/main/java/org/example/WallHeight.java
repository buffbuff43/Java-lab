package org.example;

public enum WallHeight
{
    LOW("Маленькая", 1),MEDIUM("Средняя", 3), HIGH("Высокая", 5);
    private String title;
    private  int height;
    WallHeight(String title, int height) {
        this.title = title;
        this.height = height;
    }
    public String getTitle() {
        return title;
    }
    public int getHeight() {
        return height;
    }
}
