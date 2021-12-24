package pairmatching.model;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;

	Level(String name) {
		this.name = name;
	}

	public static boolean contains(String levelString) {
		return Arrays.stream(values()).anyMatch(level -> level.is(levelString));
	}

	public boolean is(String levelString) {
		return name.equals(levelString);
	}

	public String getName() {
		return name;
	}

	public boolean is(Level level) {
		return this == level;
	}
}
