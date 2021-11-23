package dolphin;

import java.sql.Time;
import java.util.ArrayList;

public abstract class Factory{

    public Factory() {
    }

    public Member makeNewMember(int whatMember, boolean isCompetetive,boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean hasArrears) {

            return new Member(isCompetetive,isActive,dateOfBirth,name, diciplin, hasArrears);
        }


    public Team makeNewTeam(int whatTeam, String name, ArrayList<Member> contestants){

        return new Team(name,contestants);
    }

    public Competition makeNewCompetition(int whatCompetition,Diciplin diciplin, Team team, String place, int time){
        return new Competition(diciplin,team,place,time);
    }
}