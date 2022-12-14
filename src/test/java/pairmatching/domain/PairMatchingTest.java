package pairmatching.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PairMatchingTest {

    @Test
    void 짝수_인원_페어매칭_테스트() {
        PairMatching pairMatching = PairMatching.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR);

        List<Pair> pairs = pairMatching.match();

        assertThat(pairs.size()).isEqualTo(10);
    }
}
