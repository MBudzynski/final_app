package pl.sda.playlists;

public class Music extends Multimedia{

    private String author;

    public Music(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Music{" +
                "author='" + author + '\'' +
                ", title='" + getTitle() + '\'' +
                '}';
    }
}
