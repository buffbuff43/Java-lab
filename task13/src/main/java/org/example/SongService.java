package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Component
public class SongService {
    static LinkedHashSet<Song> songs = new LinkedHashSet<>();

    @PostConstruct
    public void init(){
        songs.add(new Song(1, "Беспечный Ангел", "Ария", 7));
        songs.add(new Song(2, "Ява", "Сектор Газа", 3));
        songs.add(new Song(3, "Алюминиевые огурцы", "Кино", 4));
        songs.add(new Song(4, "Wind of Change", "Scorpions", 6));
        songs.add(new Song(5, "Новый герой", "Мираж", 3));
        songs.add(new Song(6, "Не забывай", "Комбинация", 2));
        songs.add(new Song(7, "Яд", "Крематорий", 3));
        songs.add(new Song(8, "Вечер", "Пикник", 4));
        songs.add(new Song(9, "Проклятый старый дом", "КиШ", 3));
        songs.add(new Song(10, "Русский мат", "Сектор Газа", 2));
        songs.add(new Song(11, "CHIPI-CHAPA", "Tik-Tok", 1));
    }
    public void printAll(){
        System.out.println("Список песен");
        for (Song s : songs){
            System.out.println(s.getInfo());
        }
    }
    public static Song findByName(String name){
        for(Song s : songs){
            if (s.getSongName().equals(name)){
                return s;
            }
        }
        return null;
    }
    public static Song findBySingerSong(String name, String singer){
        for(Song s : songs){
            if (s.getSongName().equals(name) && s.getSingerName().equals(singer)){
                return s;
            }
        }
        return null;
    }

    public LinkedHashSet<Song> getAllSongs() {
        return songs;
    }
}
