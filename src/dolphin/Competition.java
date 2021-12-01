package dolphin;

import java.util.ArrayList;
import java.util.Scanner;

public class Competition {
    private String diciplin;
    private String place;
    private String time;
    private ArrayList<Team> competingTeams;

    public Competition(String diciplin, String place, String time, ArrayList<Team> competingTeams) {
        this.diciplin = diciplin;
        this.place = place;
        this.time = time;
    }

    public String getDiciplin() {
        return diciplin;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<Team> getCompetingTeams() {
        return competingTeams;
    }

    /*
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

/*

     */



    @Override
    public String toString() {
        return "" +
                "Disciplin " + diciplin + "\n" +
                "Place "  +  place +  "\n" +
                "Time " + time+ "\n";




    }
}
