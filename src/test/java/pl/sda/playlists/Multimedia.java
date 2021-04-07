package pl.sda.playlists;

public abstract class Multimedia implements Playable {

    private String title;

    public Multimedia(String title) {
        this.title = title;
    }

    public String play() {
        return toString();
    }

    protected String getTitle() {
        return title;
    }
}
