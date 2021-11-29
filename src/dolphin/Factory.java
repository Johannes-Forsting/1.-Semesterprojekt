package dolphin;

import java.sql.Time;
import java.util.ArrayList;

public class Factory{

    public Factory() {
    }

    public Member makeNewMember(int id, boolean isCompetetive,boolean isActive, String dateOfBirth, String name, Diciplin diciplin, boolean hasArrears) {

            return new Member(id, isCompetetive,isActive,dateOfBirth,name, diciplin, hasArrears);
        }


    public Team makeNewTeam(String diciplinName){

        return new Team(diciplinName);
    }

    public Competition makeNewCompetition(String diciplin, String place, String time){
        return new Competition(diciplin,place,time);
    }

}