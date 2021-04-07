package pl.sda.playlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void shouldPlaySequentially() {
        //given
        Music music1 = new Music("title1", "author1");
        Music music2 = new Music("title2", "author2");
        Movie movie1 = new Movie("title1");
        Movie movie2 = new Movie("title2");
        Playlist playlist = new Playlist();
        Playlist subPlaylist = new Playlist();
        Music music4 = new Music("title4", "author4");
        Music music5 = new Music("title5", "author5");
        playlist.addPlayable(music1);
        playlist.addPlayable(music2);
        playlist.addPlayable(movie1);
        playlist.addPlayable(movie2);
        playlist.addPlayable(subPlaylist);
        subPlaylist.addPlayable(music4);
        subPlaylist.addPlayable(music5);
        playlist.changePlayMode(PlayMode.SEQUENCE);
        subPlaylist.changePlayMode(PlayMode.SEQUENCE);
        //when
        String output = playlist.play();
        //then
        System.out.println(output);
    }
    @Test
    void shouldPlayRandom() {
        //given
        Music music1 = new Music("title1", "author1");
        Music music2 = new Music("title2", "author2");
        Movie movie1 = new Movie("title1");
        Movie movie2 = new Movie("title2");
        Playlist playlist = new Playlist();
        Playlist subPlaylist = new Playlist();
        Music music4 = new Music("title4", "author4");
        Music music5 = new Music("title5", "author5");
        playlist.addPlayable(music1);
        playlist.addPlayable(music2);
        playlist.addPlayable(movie1);
        playlist.addPlayable(movie2);
        playlist.addPlayable(subPlaylist);
        subPlaylist.addPlayable(music4);
        subPlaylist.addPlayable(music5);
        playlist.changePlayMode(PlayMode.SHUFFLE);
        subPlaylist.changePlayMode(PlayMode.SEQUENCE);
        //when
        String output = playlist.play();
        //then
        System.out.println(output);
    }

}
