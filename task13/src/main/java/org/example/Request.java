package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

    @Component
    public class Request {
        public LinkedHashSet<Song> songList = new LinkedHashSet<>();
        @Autowired
        SongService songService;

        public boolean add(String name){
            Song foundSong = songService.findByName(name);
            if (foundSong != null) {
                System.out.println("Заявка на добавление композиции: " + foundSong.getSingerName() + " - " + foundSong.getSongName());
                songList.add(foundSong);
                System.out.println("Композиция успешно добавлена в заявку");
                return true;
            } else {
                System.out.println("Композиция не найдена");
                return false;
            }
        }
}

