package dolphin;

import coach.Coach;

import java.util.ArrayList;

import static foreman.Foreman.*;
import static dolphin.Diciplin.*;

public class Team {
    private String teamName;
    private Diciplin diciplin;
    private ArrayList<Member> contestants;
    private boolean isSenior;
    public static ArrayList<Team> teams = new ArrayList<>();


    public Team(String teamName, Diciplin diciplin, boolean isSenior, ArrayList<Member> contestants) {
        this.diciplin = diciplin;
        this.teamName = teamName;
        this.contestants = contestants;
        this.isSenior = isSenior;


    }

    @Override
    public String toString() {
        System.out.println("Team Name: '" + teamName + "' Diciplin: '" + diciplin + "' isSenior: '" + isSenior + "' \nContestants:");
        contestants.stream().forEach((tmp) -> {
            System.out.println(tmp);
        });
        return " ";
    }

    public Diciplin getDiciplin() {
        return diciplin;
    }

    public String getTeamName(){
        return teamName;
    }


    public ArrayList<Member> getContestants() {
        return contestants;
    }

    public boolean isSenior() {
        return isSenior;
    }
}
