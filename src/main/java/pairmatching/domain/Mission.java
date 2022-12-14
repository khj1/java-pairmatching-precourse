package pairmatching.domain;

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
}
