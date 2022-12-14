package pairmatching.domain;

import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.SHOPPING, Mission.PAYMENT, Mission.SUBWAY)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", List.of(Mission.PERFORMANCE, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", Collections.emptyList());

    private final List<Mission> missions;
    private final String name;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }
}
