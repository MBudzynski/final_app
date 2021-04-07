package pl.sda.playlists;

import java.util.List;

public interface PlayStrategy {

    PlayMode strategyPlayMode();
    String prepareResult(List<Playable> playableList);

}
