package pairmatching.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CrewNamesTest {
	@Test
	void 백엔드_이름_파일_읽어오기() {
		CrewNames crewNames = new CrewNames(Course.BACKEND);

		Assertions.assertThat(crewNames.get())
			.contains("백호")
			.contains("태웅")
			.contains("덕규");
	}

	@Test
	void 프론트엔드_이름_파일_읽어오기() {
		CrewNames crewNames = new CrewNames(Course.FRONTEND);

		Assertions.assertThat(crewNames.get())
			.contains("이브")
			.contains("라라")
			.contains("윌터");
	}

}
