//Lavet af Asger

package dolphin;
import java.util.ArrayList;
public class Competition {
    private Diciplin diciplin;
    private boolean isSenior;
    private String place;
    private String time;
    private Team competingTeam;
    public static ArrayList<Competition> competitions = new ArrayList<Competition>();

    public Competition(Diciplin diciplin, boolean isSenior, String place, String time) {
        this.diciplin = diciplin;
        this.isSenior = isSenior;
        this.place = place;
        this.time = time;
    }

    public Competition(Diciplin diciplin, boolean isSenior, String place, String time, Team competingTeam) {
        this.diciplin = diciplin;
        this.isSenior = isSenior;
        this.place = place;
        this.time = time;
        this.competingTeam = competingTeam;
    }

    public Diciplin getDiciplin() {
        return diciplin;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }
    public boolean isSenior(){
        return isSenior;
    }

    public Team getCompetingTeam(){
        return competingTeam;
    }

    public void setCompetingTeam(Team team){
        this.competingTeam = team;
    }

    @Override
    public String toString() {
        String team;
        String teamMembers = "\nThe members of the team is:";
        if(competingTeam == null){
            team = "none";
            teamMembers = "";
        }else {
            team = competingTeam.getTeamName();
            for (int i = 0; i < competingTeam.getContestants().size(); i++) {
                teamMembers += "\n" + competingTeam.getContestants().get(i);
            }
        }



        return "Competition{" +
                "diciplin=" + diciplin +
                ", isSenior=" + isSenior +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", competingTeam=" + team + '}' +
                teamMembers;
    }
}
