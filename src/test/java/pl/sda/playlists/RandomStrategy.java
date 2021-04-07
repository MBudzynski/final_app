package pl.sda.playlists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomStrategy implements PlayStrategy {


    @Override
    public PlayMode strategyPlayMode() {
        return PlayMode.SHUFFLE;
    }

    @Override
    public String prepareResult(List<Playable> playableList) {
        List<Playable> copyList = new ArrayList<>(playableList);
        Collections.shuffle(copyList);
        return copyList.stream()
                .map(e -> e.play())
                .collect(Collectors.joining("\n"));
    }
}
