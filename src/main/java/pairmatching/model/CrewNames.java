package pairmatching.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewNames {
	public static final String BACKEND_CREW_NAMES_FILE_PATH = "src/main/resources/backend-crew.md";
	public static final String FRONTEND_CREW_NAMES_FILE_PATH = "src/main/resources/frontend-crew.md";

	private List<String> crewNames;

	public CrewNames(Course course) {
		if (course.isBackend()) {
			readFile(BACKEND_CREW_NAMES_FILE_PATH);
		}
		if (course.isFrontend()) {
			readFile(FRONTEND_CREW_NAMES_FILE_PATH);
		}
	}

	public List<String> get() {
		return crewNames;
	}

	public List<String> shuffle() {
		return Randoms.shuffle(crewNames);
	}

	private void readFile(String filePath) {
		try {
			crewNames = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
