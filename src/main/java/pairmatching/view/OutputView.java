package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;
import pairmatching.model.Menu;
import pairmatching.model.Mission;
import pairmatching.model.Pair;
import pairmatching.model.Pairs;

public class OutputView {

	private static final String DOT = ". ";
	private static final String DIVIDING_LINE = "#############################################";
	private static final String COURSES_PREFIX = "과정: ";
	private static final String LEVEL_PREFIX = "\t- ";
	private static final String COLON = ": ";
	private static final String PIPE_DELIMITER = " | ";
	private static final String MISSION_PREFIX = "미션:";
	private static final String COURSE_LEVEL_MISSION_INPUT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
	private static final String COURSE_LEVEL_MISSION_INPUT_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	private static final String COLON_DELIMITER = " : ";
	public static final String PAIR_MATCHING_RESULT_INIT = "페어 매칭 결과입니다.";

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

	public static void printCourseLevelMissionInputMessage() {
		printCourseLevelMissionInputInit();
		printCourseLevelMissionInputExample();
	}

	public static void printPairMatchingResult(Pairs pairs) {
		printPairsInit();
		printPairs(pairs);
	}

	private static void printPairs(Pairs pairs) {
		for (Pair pair : pairs.get()) {
			System.out.println(printPair(pair));
		}
	}

	private static void printPairsInit() {
		System.out.println(PAIR_MATCHING_RESULT_INIT);
	}

	private static String printPair(Pair pair) {
		return pair.get().stream()
			.map(Crew::getName)
			.collect(Collectors.joining(COLON_DELIMITER));
	}

	private static void printCourseLevelMissionInputExample() {
		System.out.println(COURSE_LEVEL_MISSION_INPUT_EXAMPLE);
	}

	private static void printCourseLevelMissionInputInit() {
		System.out.println(COURSE_LEVEL_MISSION_INPUT_MESSAGE);
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
			.collect(Collectors.joining(PIPE_DELIMITER));
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
			.collect(Collectors.joining(PIPE_DELIMITER));
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
