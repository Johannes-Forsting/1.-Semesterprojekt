package dolphin;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Competition {
    private Diciplin diciplin;
    private Team team;
    private ArrayList<Member> contestants;
    private String place;
    private double time;
    private ArrayList<String> competitionResults;

    public Competition(Diciplin diciplin, Team team, String place, double time) {
        this.diciplin = diciplin;
        this.team = team;
        this.place = place;
        this.time = time;
    }


    public void addCompetitionResults(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < contestants.size(); i++) {
            String currentContestantName = contestants.get(i).getName();
            System.out.println("Type in time for contestant: \"" + currentContestantName + "\":");
            competitionResults.add(sc.nextLine());
        }
        System.out.println("Competition results: \n" + competitionResults);
    }


    public void addContestantsToCompetition(ArrayList<Member> teamMembers){
        for (int i = 0; i < teamMembers.size(); i++) {
            this.contestants.add(teamMembers.get(i));
        }
    }

    public String getPlace() {
        return place;
    }

    public double getTime() {
        return time;
    }
}
