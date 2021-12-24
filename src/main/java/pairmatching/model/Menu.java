package pairmatching.model;

import java.util.Arrays;

public enum Menu {
	MATCHING("1", "페어 매칭"),
	RESULT("2", "페어 조회"),
	INITIALIZATION("3", "페어 초기화"),
	QUIT("Q", "종료");

	private final String category;
	private final String description;

	Menu(String category, String description) {
		this.category = category;
		this.description = description;
	}

	public static boolean contains(String category) {
		return Arrays.stream(values())
			.anyMatch(menu -> menu.isCategory(category));
	}

	public boolean isCategory(String category) {
		return this.category.equals(category);
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}
}
