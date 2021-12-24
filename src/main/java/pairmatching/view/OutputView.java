package pairmatching.view;

import java.util.Arrays;

import pairmatching.model.Menu;

public class OutputView {

	public static final String DOT = ". ";

	public static void printCategories() {
		printFunctionInit();
		printFunctions();
	}

	private static void printFunctions() {
		Arrays.stream(Menu.values())
			.forEach(menu -> System.out.println(menu.getCategory() + DOT + menu.getDescription()));
	}

	private static void printFunctionInit() {
		System.out.println("기능을 선택하세요.");
	}
}
