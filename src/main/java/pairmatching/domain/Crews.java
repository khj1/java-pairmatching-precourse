package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> shuffledNames = shuffleNames();

        return toCrews(shuffledNames);
    }

    private List<Crew> toCrews(List<String> shuffledNames) {
        Course course = getCourse();

        return shuffledNames.stream()
                .map(name -> Crew.create(course, name))
                .collect(Collectors.toList());
    }

    private List<String> shuffleNames() {
        return Randoms.shuffle(getNames());
    }

    private List<String> getNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    private Course getCourse() {
        return crews.stream()
                .map(Crew::getCourse)
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(" : "));
    }
}
