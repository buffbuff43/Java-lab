package org.example;

public class Wall implements Challenge{

    public Wall(WallHeight wallHeight) {
        this.height = wallHeight.getHeight();
        this.title = wallHeight.getTitle();
    }
    int height;
    String title;
    @Override
    public boolean challenge(Member member) {
        return member.jump(height);
    }
}
