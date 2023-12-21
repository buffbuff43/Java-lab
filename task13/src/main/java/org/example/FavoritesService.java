package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Component
public class FavoritesService {
    private final SongService songService;
    private final Playlist playlist;
    private MileService mileService;
    @Autowired
    Request request;
    LinkedHashSet<Song> favorite = new LinkedHashSet<>();

    public FavoritesService(SongService songService, Playlist playlist, Request request) {
        this.songService = songService;
        this.playlist = playlist;
        this.request = request;
        mileService = new MileService();
        mileService.setFavoritesService(this);
    }

    @PostConstruct
    public void init() {
    }

    public int getTimeFavorites() {
        int totalTime = 0;
        for (Song song : favorite) {
            totalTime += song.getTime();
        }
        return totalTime;
    }

    public void printTimeFavorites() {
        int totalTime = getTimeFavorites();
        int hours = totalTime / 60;
        int minutes = totalTime % 60;
        System.out.println("Общая продолжительность треков в избранном " + hours + " часов " + minutes + " минут");
    }


    public void removeFromFavorites(String songName) {
        String lowercaseSongName = songName.toLowerCase();
        Song songToRemove = null;
        for (Song song : favorite) {
            String lowercaseName = song.getSongName().toLowerCase();
            if (lowercaseName.contains(lowercaseSongName)) {
                songToRemove = song;
                break;
            }
        }
        if (songToRemove != null) {
            favorite.remove(songToRemove);
            System.out.println(songToRemove.getSongName() + " удалена из избранного.");
        } else {
            System.out.println("Песня с названием, похожим на " + songName + ", не найдена в избранном.");
        }
        System.out.println("Актуальный список избранного: ");
        printFavorites();
    }

    public void printFavorites() {
        System.out.println("Список избранного: ");
        if (favorite.isEmpty()) {
            System.out.println("Список избранного пуст.");
        } else {
            for (Song s : favorite) {
                System.out.println(s.getInfo());
            }
        }
    }

    public void addtoplaylist(String songName) {
        if (request.add(songName)) {
            if (playlist.addToPlaylist()) {
                playlist.printTotalTime();
            }
        }
    }

    public boolean addToFavorites() {
        int startSize = favorite.size();
        if (!request.songList.isEmpty()) {
            LocalDate currentDate = LocalDate.now();
            for (Song song : request.songList) {
                    if (favorite.add(song)) {
                    System.out.println("Песня " + song.getSongName() + " добавлена в избранное на " + currentDate);
                }
            }
            int finalSize = favorite.size();
            if (finalSize > startSize) {
                System.out.println("Общее количество песен в избранном: " + finalSize);
                return true;
            } else {
                System.out.println("В избранном уже есть все песни из заявки");
                return false;
            }
        }
        return false;
    }

//    private Set<String> lastAddToFavorRequest;
//
//    public void addtofavor(String... songNames) {
//        boolean addedAtLeastOne = false;
//        lastAddToFavorRequest = new LinkedHashSet<>(Arrays.asList(songNames));
//
//        for (String songName : songNames) {
//            if (request.add(songName)) {
//                if (addToFavorites()) {
//                    addedAtLeastOne = true;
//                }
//            } else {
//                System.out.println("Песня с именем " + songName + " не найдена");
//            }
//        }
//
//        if (addedAtLeastOne) {
//            String songsString = String.join(", ", lastAddToFavorRequest);
//            mileService.sendEmail(Collections.singleton(songsString));
//        } else {
//            System.out.println("Композиция не найдена");
//        }
//    }

    private LinkedHashSet<Song> lastaddfavor;
    public void addtofavor(String... songNames) {
        boolean addedAtLeastOne = false;
        lastaddfavor = new LinkedHashSet<>();
        for (String songName : songNames) {
            Song foundSong = SongService.findByName(songName);
            if (foundSong != null) {
                lastaddfavor.add(foundSong);
                if (request.add(songName)) {
                    if (addToFavorites()) {
                        addedAtLeastOne = true;
                    }
                }
            }
        }
        if (addedAtLeastOne) {
            mileService.sendEmail(lastaddfavor);
        }
        System.out.println("");

    }


    public int getFavoriteCount() {
        return favorite.size();
    }
    public void printFavoriteCount() {
        int count = getFavoriteCount();
        System.out.println("Количество треков в избранном: " + count);
    }
}
