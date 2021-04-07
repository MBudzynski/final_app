package pl.sda.playlists;

public class Movie extends Multimedia {

    public Movie(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + getTitle() + '\'' +
                '}';
    }
}
