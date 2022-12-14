package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.List;

public class ContentsRequestDto {

    private static final int COURSE = 0;
    private static final int LEVEL = 1;
    private static final int MISSION = 2;
    private static final int VALID_SIZE = 3;

    private final Course course;
    private final Level level;
    private final Mission mission;

    public ContentsRequestDto(List<String> contents) {
        validate(contents);

        this.course = Course.from(contents.get(COURSE).trim());
        this.level = Level.from(contents.get(LEVEL).trim());
        this.mission = Mission.from(contents.get(MISSION).trim());
    }

    private void validate(List<String> contents) {
        if (isInvalidSize(contents)) {
            throw new IllegalArgumentException("누락된 정보가 있습니다");
        }
    }

    private boolean isInvalidSize(List<String> contents) {
        return contents.size() != VALID_SIZE;
    }

    public static ContentsRequestDto from(List<String> contents) {
        return new ContentsRequestDto(contents);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
