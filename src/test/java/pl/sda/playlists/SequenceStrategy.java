package pl.sda.playlists;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public class SequenceStrategy implements PlayStrategy {
    @Override
    public PlayMode strategyPlayMode() {
        return PlayMode.SEQUENCE;
    }

    @Override
    public String prepareResult(List<Playable> playableList) {
        return playableList.stream()
                .map(e -> e.play())
                .collect(Collectors.joining("\n"));
    }
}
