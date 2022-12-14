package pairmatching.command;

import pairmatching.controller.Controllable;
import pairmatching.controller.InitController;
import pairmatching.controller.InquiryController;
import pairmatching.controller.MatchingController;

import java.util.Arrays;

public enum MainCommand {

    MATCHING("1", "페어 매칭", new MatchingController()),
    INQUIRY("2", "페어 조회", new InquiryController()),
    INIT("3", "페어 초기화", new InitController()),
    QUIT("Q", "종료", () -> {
    });

    private static final String NO_SUCH_MAIN_COMMAND = "잘못된 값을 입력했습니다.";
    private final String description;
    private final String command;
    private final Controllable controllable;

    MainCommand(String command, String description, Controllable controllable) {
        this.command = command;
        this.description = description;
        this.controllable = controllable;
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

    public boolean isMatching() {
        return this == MATCHING;
    }

    public boolean isInquiry() {
        return this == INQUIRY;
    }

    public boolean isRunnable() {
        return this != QUIT;
    }

    public void run() {
        controllable.run();
    }

    @Override
    public String toString() {
        return command + ". " + description;
    }
}
