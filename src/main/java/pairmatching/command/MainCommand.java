package pairmatching.command;

import java.util.Arrays;

public enum MainCommand {

    MATCHING("1", "페어 매칭"),
    INQUIRY("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String NO_SUCH_MAIN_COMMAND = "잘못된 값을 입력했습니다.";
    private final String description;
    private final String command;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand from(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.hasSameCommand(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_MAIN_COMMAND));
    }

    private boolean hasSameCommand(String command) {
        return this.command.equals(command);
    }
}
