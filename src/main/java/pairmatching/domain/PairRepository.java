package pairmatching.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairRepository {

    private static Map<Course, List<Pair>> pairsByCourse = new EnumMap<>(Course.class);

    public static void save(List<Pair> pairs, Course course) {
        pairsByCourse.put(course, pairs);
    }

    public static List<Pair> findByCourseAndMission(Course course, Mission mission) {
        List<Pair> pairs = pairsByCourse.get(course);
        return pairs.stream()
                .filter(pair -> pair.hasSameMission(mission))
                .collect(Collectors.toUnmodifiableList());
    }
}
