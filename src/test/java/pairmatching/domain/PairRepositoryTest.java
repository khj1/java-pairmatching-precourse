package pairmatching.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PairRepositoryTest {

    @BeforeEach
    void setUp() {
        PairMatching pairMatching = PairMatching.create(Course.BACKEND, Level.LEVEL1, Mission.LOTTO);
        List<Pair> pairs = pairMatching.match();
        PairRepository.save(pairs, Course.BACKEND);
    }

    @Test
    void 페어_정보_조회_기능_테스트() {
        List<Pair> result = PairRepository.findByCourseAndMission(Course.BACKEND, Mission.LOTTO);

        assertThat(result)
                .extracting("mission")
                .contains(Mission.LOTTO)
                .size()
                .isEqualTo(10);
    }

    @Test
    void 매칭_이력이_없는_경우_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PairRepository.findByCourseAndMission(Course.BACKEND, Mission.DISTRIBUTION));
    }

    @Test
    void 페어를_초기화시킬_수_있다() {
        PairRepository.clear();

        assertThat(PairRepository.pairs()).isEmpty();
    }
}
