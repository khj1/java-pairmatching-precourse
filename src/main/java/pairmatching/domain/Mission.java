package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DISTRIBUTION("배포");

    private static final String NO_SUCH_MISSION = "존재하지 않는 미션입니다.";
    private final String name;

    Mission(String missionName) {
        this.name = missionName;
    }

    public static Mission from(String name) {
        return Arrays.stream(values())
                .filter(mission -> mission.hasSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_MISSION));
    }

    private boolean hasSameName(String name) {
        return this.name.equals(name);
    }
}
