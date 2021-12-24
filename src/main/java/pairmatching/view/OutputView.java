package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Menu;
import pairmatching.model.Mission;

public class OutputView {

	private static final String DOT = ". ";
	private static final String DIVIDING_LINE = "#############################################";
	private static final String COURSES_PREFIX = "과정: ";
	private static final String LEVEL_PREFIX = "\t- ";
	private static final String COLON = ": ";
	private static final String DELIMITER = " | ";
	private static final String MISSION_PREFIX = "미션:";

	public static void printCategories() {
		printFunctionInit();
		printFunctions();
	}

	public static void printGeneralInformation() {
		printDividingLine();
		printCourses();
		printMissions();
		printDividingLine();
	}

	private static void printMissions() {
		printMissionPrefix();
		printMissionsByLevel();

	}

	private static void printMissionsByLevel() {
		Arrays.stream(Level.values()).forEach(level -> {
			printLevelPrefix(level);
			printMissionByLevel(level);
		});
	}

	private static void printMissionByLevel(Level level) {
		System.out.println(getMissionByLevelString(level));
	}

	private static String getMissionByLevelString(Level level) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.isLevel(level))
			.map(Mission::getName)
			.collect(Collectors.joining(DELIMITER));
	}

	private static void printLevelPrefix(Level level) {
		System.out.print(LEVEL_PREFIX + level.getName() + COLON);
	}

	private static void printMissionPrefix() {
		System.out.println(MISSION_PREFIX);
	}

	private static void printCourses() {
		System.out.print(COURSES_PREFIX + getCoursesString());
	}

	private static String getCoursesString() {
		return Arrays.stream(Course.values())
			.map(Course::getName)
			.collect(Collectors.joining(DELIMITER));
	}

	private static void printDividingLine() {
		System.out.println(DIVIDING_LINE);
	}

	private static void printFunctions() {
		Arrays.stream(Menu.values())
			.forEach(menu -> System.out.println(menu.getCategory() + DOT + menu.getDescription()));
	}

	private static void printFunctionInit() {
		System.out.println("기능을 선택하세요.");
	}
}
