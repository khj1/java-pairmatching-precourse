package pairmatching.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "사이드엔드"})
    void 과정_이름_유효성_검증(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Course.from(name));
    }
}
