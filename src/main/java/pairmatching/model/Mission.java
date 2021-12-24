package pairmatching.model;

import static pairmatching.model.Level.*;

import java.util.Arrays;

public enum Mission {
	RACING_CAR(LEVEL1, "자동차경주"),
	LOTTO(LEVEL1, "로또"),
	BASEBALL(LEVEL1, "숫자야구게임"),
	BASKET(LEVEL2, "장바구니"),
	PAYMENT(LEVEL2, "결제"),
	PATHWAY(LEVEL2, "지하철노선도"),
	IMPROVEMENT(LEVEL4, "성능개선"),
	DISTRIBUTION(LEVEL4, "배포");

	private final Level level;
	private final String name;

	Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public static boolean contains(String missionString) {
		return Arrays.stream(values()).anyMatch(mission -> mission.isName(missionString));
	}

	public boolean isName(String missionString) {
		return name.equals(missionString);
	}

	public boolean isLevel(Level level) {
		return this.level.is(level);
	}

	public String getName() {
		return name;
	}
}
