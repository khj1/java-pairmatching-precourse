package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private static final String NO_SUCH_COURSE = "존재하지 않는 고정입니다.";

    private final String resource;
    private final String name;

    Course(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public static Course from(String name) {
        return Arrays.stream(values())
                .filter(course -> course.hasSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COURSE));
    }

    private boolean hasSameName(String name) {
        return this.name.equals(name);
    }

    public String getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return name;
    }
}
