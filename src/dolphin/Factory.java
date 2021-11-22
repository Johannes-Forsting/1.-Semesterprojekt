package dolphin;

public abstract class Factory{

    public Factory() {
    }

    public Member makeNewMember(int whatMember) {

            return new Member(true,true,18,"j",true,12);

        }


    public Team makeNewTeam(int whatTeam){

        return new Team();
    }

    public Competition makeNewCompetition(int whatCompetition){
        return new Competition();
    }
}