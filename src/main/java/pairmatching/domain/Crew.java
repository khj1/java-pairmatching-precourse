package pairmatching.domain;

public class Crew {

    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew create(Course course, String name) {
        return new Crew(course, name);
    }

    public boolean hasSameCourse(Course course) {
        return this.course == course;
    }
}
