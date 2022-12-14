package pairmatching.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "오징어게임"})
    void 미션이름_유효성_검증_테스트(String missionName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Mission.from(missionName));
    }
}
