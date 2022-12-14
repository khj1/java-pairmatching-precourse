package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = " | ";

    public void printContents() {
        System.out.println();
        printSeparator();
        printCourses();
        printMissionsByLevel();
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("#############################################");
    }

    private void printCourses() {
        System.out.print("과정: ");
        System.out.println(getCourses());
    }

    private String getCourses() {
        return Arrays.stream(Course.values())
                .map(Course::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private void printMissionsByLevel() {
        System.out.println("미션: ");
        System.out.println(getMissionsByLevel());
    }

    private String getMissionsByLevel() {
        return Arrays.stream(Level.values())
                .map(Level::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
