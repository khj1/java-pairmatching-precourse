package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatching {

    private final Crews crews;
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairMatching(Crews crews, Course course, Level level, Mission mission) {
        this.crews = crews;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairMatching create(Course course, Level level, Mission mission) {
        return new PairMatching(Crews.create(course), course, level, mission);
    }

    public List<Pair> match() {
        List<Pair> pairs = new ArrayList<>();
        List<Crew> shuffled = new ArrayList<>(crews.shuffle());

        while (shuffled.size() > 1) {
            Crews pairedCrews = Crews.of(shuffled.remove(0), shuffled.remove(0));
            Pair pair = Pair.create((pairedCrews), mission);
            pairs.add(pair);
        }
        PairRepository.save(pairs, course);
        return pairs;
    }
}
