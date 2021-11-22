package dolphin;

import java.sql.Time;
import java.util.ArrayList;

public class Competition {
    private Diciplin diciplin;
    private Team team;
    private ArrayList<Member> contestants;
    private String place;
    private Time time;
    private ArrayList<String> competitionResults;

    public Competition(Diciplin diciplin, Team team, ArrayList<Member> contestants, String place, Time time) {
        this.diciplin = diciplin;
        this.team = team;
        this.contestants = contestants;
        this.place = place;
        this.time = time;
    }

    public void addContestantsToCompetition(ArrayList<Member> x){

    }



}
