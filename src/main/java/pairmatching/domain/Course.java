package pairmatching.domain;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private final String resource;
    private final String name;

    Course(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
