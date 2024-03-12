
package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}


class Album {

    public static class SongList extends ArrayList<Song>{

        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }
    }

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNo, LinkedList<Song> playList) {
        if (trackNo < 1 || trackNo > songs.size()) {
            return false;
        }
        Song song = songs.get(trackNo - 1);
        playList.add(song);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }

        return false;
    }
}






class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}