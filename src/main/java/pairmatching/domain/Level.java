package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", List.of(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.SHOPPING, Mission.PAYMENT, Mission.SUBWAY)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", List.of(Mission.PERFORMANCE, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", Collections.emptyList());

    private static final String NO_SUCH_LEVEL = "존재하지 않는 레벨입니다.";

    private final List<Mission> missions;
    private final String name;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level from(String name) {
        return Arrays.stream(values())
                .filter(level -> level.hasSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_LEVEL));
    }

    private boolean hasSameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return "\t- " + name + ": " + getMissions();
    }

    private String getMissions() {
        return missions.stream()
                .map(Mission::toString)
                .collect(Collectors.joining(" | "));
    }
}
