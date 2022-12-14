package pairmatching.view;

import pairmatching.domain.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPairs(List<Pair> pairs) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(toString(pairs));
        System.out.println();
    }

    private static String toString(List<Pair> pairs) {
        return pairs.stream()
                .map(Pair::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println();
        System.out.print("[ERROR] ");
        System.out.println(e.getMessage());
    }
}
