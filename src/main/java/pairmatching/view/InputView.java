package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Menu;
import pairmatching.model.Mission;

public class InputView {

	public static final String WRONG_CATEGORY_INPUT = "존재하지 않는 기능입니다.";
	public static final String REGEX = ",";
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;
	public static final String MISSION_NOT_EXIST = "존재하지 않는 미션입니다.";
	public static final String LEVEL_NOT_EXIST = "존재하지 않는 레벨입니다.";
	public static final String COURSE_NOT_EXIST = "존재하지 않는 과정입니다.";
	public static final String MISSED_INFORMATION = "과정, 레벨, 미션을 모두 입력해주세요.";
	public static final int INFORMATION_SIZE = 3;

	public static String inputCategory() {
		String category = Console.readLine();
		validateMenuContains(category);

		return category;
	}

	public static String inputCourseLevelMission() {
		String courseLevelMission = Console.readLine();
		validateCourseLevelMission(courseLevelMission);

		return courseLevelMission;
	}

	private static void validateCourseLevelMission(String courseLevelMission) {
		String[] courseLevelMissionArray = courseLevelMission.split(REGEX);

		validateInfoNotMissed(courseLevelMissionArray);
		validateCourse(courseLevelMissionArray[COURSE_INDEX]);
		validateLevel(courseLevelMissionArray[LEVEL_INDEX]);
		validateMission(courseLevelMissionArray[MISSION_INDEX]);
	}

	private static void validateMission(String mission) {
		if (!Mission.contains(mission)) {
			throw new IllegalArgumentException(MISSION_NOT_EXIST);
		}
	}

	private static void validateLevel(String level) {
		if (!Level.contains(level)) {
			throw new IllegalArgumentException(LEVEL_NOT_EXIST);
		}
	}

	private static void validateCourse(String course) {
		if (!Course.contains(course)) {
			throw new IllegalArgumentException(COURSE_NOT_EXIST);
		}
	}

	private static void validateInfoNotMissed(String[] courseLevelMissionArray) {
		if (courseLevelMissionArray.length < INFORMATION_SIZE) {
			throw new IllegalArgumentException(MISSED_INFORMATION);
		}
	}

	private static void validateMenuContains(String category) {
		if (!Menu.contains(category)) {
			throw new IllegalArgumentException(WRONG_CATEGORY_INPUT);
		}
	}
}
