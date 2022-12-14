package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.command.MainCommand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REGEX = ",";

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
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");

        return Arrays.asList(Console.readLine().split(REGEX));
    }
}
