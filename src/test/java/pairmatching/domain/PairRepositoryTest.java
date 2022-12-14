package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PairRepositoryTest {

    @Test
    void 페어_정보_조회_기능_테스트() {
        PairMatching pairMatching = PairMatching.create(Course.BACKEND, Level.LEVEL1, Mission.LOTTO);
        List<Pair> pairs = pairMatching.match();
        PairRepository.save(pairs, Course.BACKEND);

        List<Pair> result = PairRepository.findByCourseAndMission(Course.BACKEND, Mission.LOTTO);

        Assertions.assertThat(result)
                .extracting("mission")
                .contains(Mission.LOTTO)
                .size()
                .isEqualTo(10);
    }
}
