package dolphin;
import java.util.ArrayList;
public class Competition {
    private Diciplin diciplin;
    private boolean isSenior;
    private String place;
    private String time;
    private ArrayList<Team> competingTeams;
    public static ArrayList<Competition> competitions = new ArrayList<Competition>();

    public Competition(Diciplin diciplin, boolean isSenior, String place, String time, ArrayList<Team> competingTeams) {
        this.diciplin = diciplin;
        this.isSenior = isSenior;
        this.place = place;
        this.time = time;
        this.competingTeams = competingTeams;
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

    public static ArrayList<Team> getTeamFromDiciplin(Diciplin diciplin, boolean isSenior){
        ArrayList<Team> teamsWithSameDiciplin = new ArrayList<>();
        for (int i = 0; i < Team.teams.size(); i++) {
            if (Team.teams.get(i).getDiciplin().equals(diciplin)){
                if (Team.teams.get(i).isSenior() && isSenior){
                    teamsWithSameDiciplin.add(Team.teams.get(i));
                }
            }
        }

        return teamsWithSameDiciplin;
    }

    @Override
    public String toString() {
        String teams = " ";
        for (int i = 0; i < competingTeams.size(); i++) {

            teams += " " + competingTeams.get(i).getTeamName();

        }
        return "" +
                "Disciplin " + diciplin + "\n" +
                "Place "  +  place +  "\n" +
                "Time " + time + "\n" +
                "Competing Teams " + teams;

    }
}
