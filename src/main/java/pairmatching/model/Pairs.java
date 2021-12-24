package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
	public static final int EVEN_DIVISOR = 2;
	public static final int NO_REMAINDER = 0;
	public static final int INCREMENT = 2;
	public static final int INIT_INDEX = 0;
	public static final int NEXT_INDEX = 1;

	private final List<Pair> pairs;

	public Pairs(List<String> crewNames, Course course) {
		pairs = matchPair(crewNames, course);
	}

	public List<Pair> get() {
		return pairs;
	}

	private List<Pair> matchPair(List<String> crewNames, Course course) {
		if (isCrewNamesSizeOdd(crewNames)) {
			return pairMatchingOfOddSize(crewNames, course);
		}
		return pairMatchingOfEvenSize(crewNames, course);
	}

	private List<Pair> pairMatchingOfOddSize(List<String> crewNames, Course course) {
		//TODO
		return null;
	}

	private List<Pair> pairMatchingOfEvenSize(List<String> crewNames, Course course) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = INIT_INDEX; i < crewNames.size(); i += INCREMENT) {
			Crew crewA = Crew.create(crewNames.get(i), course);
			Crew crewB = Crew.create(crewNames.get(i + NEXT_INDEX), course);

			pairs.add(Pair.create(crewA, crewB));
		}

		return pairs;
	}

	private static boolean isCrewNamesSizeOdd(List<String> crewNames) {
		return crewNames.size() % EVEN_DIVISOR != NO_REMAINDER;
	}
}
