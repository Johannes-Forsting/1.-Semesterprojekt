package dolphin;

import java.util.ArrayList;
import static dolphin.Team.teams;

public class Factory{

    public Factory() {
    }

    public Member makeNewMember(int id, boolean isCompetitive,boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean hasArrears) {

            return new Member(id, isCompetitive,isActive,dateOfBirth,name, diciplin, hasArrears);
        }


    public Team makeNewTeam(String teamName, Diciplin diciplin, boolean isSenior, ArrayList<Member> contestants){
        Team tmpTeam = new Team(teamName, diciplin, isSenior, contestants);
        teams.add(tmpTeam);
        return tmpTeam;
    }



    public Competition makeNewCompetition(Diciplin diciplin, boolean isSenior, String place, String time){
        return new Competition(diciplin, isSenior, place, time);
    }

    public Competition makeNewCompetition(Diciplin diciplin, boolean isSenior, String place, String time, Team team){
        return new Competition(diciplin, isSenior, place, time, team);
    }
}