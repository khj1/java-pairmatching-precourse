package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Crews {

    private final List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews create(Course course) {
        return new Crews(CrewRepository.findByCourse(course));
    }

    public List<Crew> shuffle() {
        List<Crew> shuffled = Randoms.shuffle(crews);

        return Collections.unmodifiableList(shuffled);
    }
}
