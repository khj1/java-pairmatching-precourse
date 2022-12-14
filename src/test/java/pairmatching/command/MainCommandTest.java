package pairmatching.command;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MainCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "4"})
    void 메인_명령어_입력_유효성_검증_테스트(String command) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MainCommand.from(command));
    }
}
