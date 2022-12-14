package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatching {

    private final Crews crews;
    private final Level level;
    private final Mission mission;

    public PairMatching(Crews crews, Level level, Mission mission) {
        this.crews = crews;
        this.level = level;
        this.mission = mission;
    }

    public static PairMatching create(Course course, Level level, Mission mission) {
        return new PairMatching(Crews.create(course), level, mission);
    }

    public List<Pair> match() {
        List<Pair> pairs = new ArrayList<>();
        List<Crew> shuffled = crews.shuffle();

        while (shuffled.size() > 1) {
            Crews pairedCrews = Crews.of(shuffled.remove(0), shuffled.remove(0));
            Pair pair = Pair.create((pairedCrews), level);
            pairs.add(pair);
        }
        return pairs;
    }
}
