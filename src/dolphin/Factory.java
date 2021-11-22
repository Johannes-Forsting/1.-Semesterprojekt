package dolphin;

import java.sql.Time;
import java.util.ArrayList;

public abstract class Factory{

    public Factory() {
    }

    public Member makeNewMember(int whatMember, boolean isCompetetive,boolean isActive, String dateOfBirth, String name, boolean arrears) {

            return new Member(isCompetetive,isActive,dateOfBirth,name,arrears);
        }


    public Team makeNewTeam(int whatTeam, String name, ArrayList<Member> contestants){

        return new Team(name,contestants);
    }

    public Competition makeNewCompetition(int whatCompetition,Diciplin diciplin, Team team, ArrayList<Member> contestants, String place, int time){
        return new Competition(diciplin,team,contestants,place,time);
    }
}