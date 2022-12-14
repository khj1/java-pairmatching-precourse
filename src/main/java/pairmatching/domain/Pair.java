package pairmatching.domain;

public class Pair {

    private final Crews crews;
    private final Mission mission;

    public Pair(Crews crews, Mission mission) {
        this.crews = crews;
        this.mission = mission;
    }

    public static Pair create(Crews crews, Mission mission) {
        return new Pair(crews, mission);
    }

    public boolean hasSameMission(Mission mission) {
        return this.mission == mission;
    }
    
    @Override
    public String toString() {
        return crews.toString();
    }
}
