package pairmatching.model;

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

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}
}
