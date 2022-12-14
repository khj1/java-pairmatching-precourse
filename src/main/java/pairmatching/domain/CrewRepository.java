package pairmatching.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {

    private static final List<Crew> crews = new ArrayList<>();

    static {
        crews.addAll(convertToCrew(Course.BACKEND));
        crews.addAll(convertToCrew(Course.FRONTEND));
    }

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    private static List<Crew> convertToCrew(Course course) {
        List<String> names = readFile(course);
        return names.stream()
                .map(name -> Crew.create(course, name))
                .collect(Collectors.toList());
    }

    private static List<String> readFile(Course course) {
        try {
            return Files.readAllLines(Paths.get(course.getResource()));
        } catch (IOException error) {
            throw new IllegalArgumentException("파일을 읽어들일 수 없습니다.");
        }
    }

    public static List<Crew> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.hasSameCourse(course))
                .collect(Collectors.toList());
    }
}
