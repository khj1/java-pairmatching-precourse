package pairmatching.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "레벨6"})
    void 레벨_이름_유효성_검증_테스트(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.from(name));
    }
}
