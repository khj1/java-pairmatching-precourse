package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Menu;

public class InputView {

	public static final String WRONG_CATEGORY_INPUT = "존재하지 않는 기능입니다.";

	public static String inputCategory() {
		String category = Console.readLine();
		validateMenuContains(category);

		return category;
	}

	private static void validateMenuContains(String category) {
		if (!Menu.contains(category)) {
			throw new IllegalArgumentException(WRONG_CATEGORY_INPUT);
		}
	}
}
