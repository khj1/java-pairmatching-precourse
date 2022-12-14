package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.command.MainCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

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
}
