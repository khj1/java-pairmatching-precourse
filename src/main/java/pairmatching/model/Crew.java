package pairmatching.model;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Crew create(String name, Course course) {
		return new Crew(course, name);
	}
}
