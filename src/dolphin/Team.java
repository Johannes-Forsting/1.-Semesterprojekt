package dolphin;

import java.util.ArrayList;

import static foreman.Main.*;

public class Team {
    private String teamName;
        private Diciplin diciplin;
        private ArrayList<Member> contestants;
        private boolean isSenior;



        private ArrayList<Double> bestTimes;

        //TODO hvis en person har 2 tider på top5

    public Team(String teamName, Diciplin diciplin, boolean isSenior) {
        this.diciplin = diciplin;
        this.teamName = teamName;

        switch (diciplin.getDiciplinName().toLowerCase()){
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
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", diciplin=" + diciplin +
                ", contestants=\n" + contestants.get(0) + "\n" + contestants.get(1) + "\n" + contestants.get(2) + "\n" + contestants.get(3) + "\n" + contestants.get(4)
                + '}';
    }
/*

    public ArrayList<Member> getMembersForTop5Team(Diciplin diciplin){
        ArrayList<Member> membersForTop5Team = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()){
            case "crawl":
                for (int i = 0; i < 5; i++) {
                    int resultId = Diciplin.getDiciplinBestTimes(crawl).get(i).getMemberId();
                    for (int j = 0; j < FilesForeman.getMembersFromFile().size(); j++) {
                        if (resultId == FilesForeman.getMembersFromFile().get(j).getMemberID()){
                            membersForTop5Team.add(FilesForeman.getMembersFromFile().get(j));
                        }
                    }
                }
                break;
            case "backcrawl":
                Top5Results = Diciplin.getDiciplinBestTimes(backCrawl);
                break;
            case "breaststroke":
                Top5Results = Diciplin.getDiciplinBestTimes(breastStroke);
                break;
            case "butterfly":
                Top5Results = Diciplin.getDiciplinBestTimes(butterFly);
                break;
            default:
                System.out.println("Diciplin not found");
                break;
        }


        return membersForTop5Team;
    }

*/
    //results
    //arraylist
    //split regx :
    //memberId : member timeResult
    //1234 : 184.5
    //
    //
    //setResults
    //read file:
    //memberId : memberResult
    //int result = split regx : get[1]
    //while(file hasnextLine)
    //member.setresults(result)

    public void setContestantsResults(ArrayList results, Member member) {
        //some shit thats not working == member.setSwimmingResults(results.get(indexOfContestantResult));
        //then members will have setPR, and method call from here.
        //this.results = results;
    }

    public void setResults(/*resultsfrom file, */){
        //reads file, and add results by memberId and time accordingly

    }

    //Team topFive = new Team("Top 5", );

    //public ArrayList<Member> getBestTimes();

    public ArrayList<Double> updateBestTimes() {
        return bestTimes;
    }

}
