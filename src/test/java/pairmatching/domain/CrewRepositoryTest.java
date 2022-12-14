package pairmatching.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewRepositoryTest {

    @Test
    void 과정별_크루_명단을_파일에서_읽어올_수_있다() {
        List<Crew> crews = CrewRepository.crews();

        assertThat(crews.size()).isEqualTo(35);
    }

    @Test
    void 크루_명단을_과정별로_불러올_수_있다() {
        List<Crew> crews = CrewRepository.findByCourse(Course.FRONTEND);

        boolean expected = crews.stream()
                .allMatch(crew -> crew.hasSameCourse(Course.FRONTEND));

        assertThat(expected).isTrue();
    }
}