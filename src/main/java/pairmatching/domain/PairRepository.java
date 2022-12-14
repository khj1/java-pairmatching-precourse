package pairmatching.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairRepository {

    private static Map<Course, List<Pair>> pairs = new EnumMap<>(Course.class);

    public static void save(List<Pair> newPairs, Course course) {
        pairs.put(course, newPairs);
    }

    public static List<Pair> findByCourseAndMission(Course course, Mission mission) {
        List<Pair> pairs = findPairsByCourse(course);

        return findPairsByMission(mission, pairs);
    }

    private static List<Pair> findPairsByMission(Mission mission, List<Pair> pairs) {
        List<Pair> pairsByMission = pairs.stream()
                .filter(pair -> pair.hasSameMission(mission))
                .collect(Collectors.toUnmodifiableList());

        if (pairsByMission.isEmpty()) {
            throw new IllegalArgumentException("해당 미션에선 매칭 이력이 존재하지 않습니다.");
        }
        return pairsByMission;
    }

    private static List<Pair> findPairsByCourse(Course course) {
        if (pairs.isEmpty()) {
            throw new IllegalArgumentException("매칭 이력이 존재하지 않습니다.");
        }
        List<Pair> pairs = PairRepository.pairs.get(course);
        if (pairs.isEmpty()) {
            throw new IllegalArgumentException("해당 과정에선 매칭 이력이 존재하지 않습니다.");
        }
        return pairs;
    }
}
