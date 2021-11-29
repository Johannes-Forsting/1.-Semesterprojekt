package dolphin;

import fileIO.ResultObject;

import java.util.ArrayList;

import static foreman.Main.*;

public class Team {
    private String teamName;
        private String diciplinName;
        private ArrayList<ResultObject> contestants;
        private boolean isTop5;


        private ArrayList<Double> bestTimes;

    public Team(String diciplinName, ArrayList<ResultObject> contestants) {
        this.diciplinName = diciplinName;
        this.contestants = contestants;
    }

    public String getDiciplinName(Diciplin name){
      //  if (diciplinName == )


        return diciplinName;
    }

    public Team(Diciplin diciplin, ArrayList<ResultObject> contestants, boolean isTop5){
        this.diciplinName = diciplin.getDiciplinName() + " Top 5";
        this.contestants = getDiciplinTop5Team();
        this.isTop5 = true;
    }


    private ArrayList<ResultObject> getDiciplinTop5Team(){
        switch (this.diciplinName.toLowerCase()){
            case "crawl":
                this.contestants = Diciplin.getDiciplinBestTimes(crawl);
                break;
            case "backcrawl":
                this.contestants = Diciplin.getDiciplinBestTimes(backCrawl);
                break;
            case "breaststroke":
                this.contestants = Diciplin.getDiciplinBestTimes(breastStroke);
                break;
            case "butterfly":
                this.contestants = Diciplin.getDiciplinBestTimes(butterFly);
                break;
            default:
                System.out.println("Diciplin not found");
                break;
        }
                return this.contestants;
    }

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
