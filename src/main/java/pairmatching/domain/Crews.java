package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Crews {

    private final List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews create(Course course) {
        return new Crews(CrewRepository.findByCourse(course));
    }

    public static Crews of(Crew... crews) {
        return new Crews(Arrays.asList(crews));
    }

    public List<Crew> shuffle() {
        return Randoms.shuffle(crews);
    }
}