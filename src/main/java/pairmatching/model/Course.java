package pairmatching.model;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static boolean contains(String courseString) {
		return Arrays.stream(values()).anyMatch(course -> course.is(courseString));
	}

	private boolean is(String course) {
		return name.equals(course);
	}

	public String getName() {
		return name;
	}
}
