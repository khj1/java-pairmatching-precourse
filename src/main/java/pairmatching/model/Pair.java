package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair {
	private final List<Crew> pair = new ArrayList<>();

	public Pair(Crew... crews) {
		Collections.addAll(pair, crews);
	}

	public static Pair create(Crew... crews) {
		return new Pair(crews);
	}
}
