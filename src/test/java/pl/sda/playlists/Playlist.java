package pl.sda.playlists;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Playable {

    private List<Playable> elements = new ArrayList<>();
    private PlayMode playMode;
    private List<PlayStrategy> playStrategyList;

    {
        playStrategyList = new ArrayList<>();
        playStrategyList.add(new SequenceStrategy());
        playStrategyList.add(new RandomStrategy());
    }

    @Override
    public String play() {
        for (PlayStrategy playStrategy : playStrategyList) {
            if (playStrategy.strategyPlayMode() == playMode) {
                return playStrategy.prepareResult(elements);
            }
        }
        return null;
    }

    public void addPlayable(Playable playable) {
        elements.add(playable);
    }

    public void changePlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }
}
