package dolphin;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static foreman.Main.*;

public class Team {
    private String teamName;
    private Diciplin diciplin;
    private ArrayList<Member> contestants;
    private boolean isSenior;
    public static ArrayList<Team> teams = new ArrayList<>();

    //TODO hvis en person har 2 tider på top5

    public Team(String teamName, Diciplin diciplin, boolean isSenior, ArrayList<Member> contestants) {
        this.diciplin = diciplin;
        this.teamName = teamName;
        this.contestants = contestants;
        this.isSenior = isSenior;

        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                this.contestants = Coach.getTop5Members(crawl, this.isSenior);
                break;
            case "backcrawl":
                this.contestants = Coach.getTop5Members(backCrawl, this.isSenior);
                break;
            case "breaststroke":
                this.contestants = Coach.getTop5Members(breastStroke, this.isSenior);
                break;
            case "butterfly":
                this.contestants = Coach.getTop5Members(butterFly, this.isSenior);
                break;
            default:
                break;
        }


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
