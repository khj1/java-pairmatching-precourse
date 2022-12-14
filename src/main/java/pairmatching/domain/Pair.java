package pairmatching.domain;

public class Pair {

    private final Crews crews;
    private final Level level;

    public Pair(Crews crews, Level level) {
        this.crews = crews;
        this.level = level;
    }

    public static Pair create(Crews crews, Level level) {
        return new Pair(crews, level);
    }

    @Override
    public String toString() {
        return crews.toString();
    }
}
