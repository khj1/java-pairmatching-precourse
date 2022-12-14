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

    private final String missionName;

    Mission(String missionName) {
        this.missionName = missionName;
    }

    public static Mission from(String missionName) {
        return Arrays.stream(values())
                .filter(mission -> mission.hasSameMissionName(missionName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
    }

    private boolean hasSameMissionName(String missionName) {
        return this.missionName.equals(missionName);
    }
}
