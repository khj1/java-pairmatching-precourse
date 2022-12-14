package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.command.MainCommand;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REGEX = ",";
    private static final String DELIMITER = " | ";

    public MainCommand readMainCommand() {
        printMain();
        return MainCommand.from(Console.readLine());
    }

    private void printMain() {
        System.out.println("기능을 선택하세요.");
        System.out.println(makeMainScreen());
    }

    private String makeMainScreen() {
        return Arrays.stream(MainCommand.values())
                .map(MainCommand::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public List<String> readLevelCourseMission() {
        printContents();
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");

        return Arrays.asList(Console.readLine().split(REGEX));
    }

    private void printContents() {
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
