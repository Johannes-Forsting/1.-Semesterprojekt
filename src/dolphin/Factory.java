package dolphin;

import java.sql.Time;
import java.util.ArrayList;

import static dolphin.Team.teams;
import static foreman.Main.crawl;


public class Factory{

    public Factory() {
    }

    public Member makeNewMember(int id, boolean isCompetetive,boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean hasArrears) {

            return new Member(id, isCompetetive,isActive,dateOfBirth,name, diciplin, hasArrears);
        }


    public Team makeNewTeam(String teamName, Diciplin diciplin, boolean isSenior, ArrayList<Member> contestants){
        Team tmpTeam = new Team(teamName, diciplin, isSenior, contestants);
        teams.add(tmpTeam);
        return tmpTeam;
    }



    public Competition makeNewCompetition(Diciplin diciplin, boolean isSenior, String place, String time, ArrayList<Team> competingTeams){
        return new Competition(diciplin, isSenior, place, time, competingTeams);
    }
}