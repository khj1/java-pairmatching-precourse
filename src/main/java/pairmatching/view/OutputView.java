package pairmatching.view;

import pairmatching.command.MainCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    public void printMain() {
        System.out.println("기능을 선택하세요.");
        System.out.println(makeMainScreen());
        System.out.println();
    }

    private String makeMainScreen() {
        return Arrays.stream(MainCommand.values())
                .map(MainCommand::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
