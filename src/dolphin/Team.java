package dolphin;

import fileIO.ResultObject;

import java.util.ArrayList;

public class Team {
        private String diciplinName;
        private ArrayList<ResultObject> contestants;
        private int teamsize;


        private ArrayList<Double> bestTimes;

    public Team(String diciplinName) {
        this.diciplinName = diciplinName;

    }

    public String getDiciplinName(Diciplin name){
      //  if (diciplinName == )


        return diciplinName;
    }

    public Top5Team(String diciplinName, ArrayList<ResultObject> contestants, int teamsize){
        this.diciplinName = diciplinName;


    }


    public ArrayList<ResultObject> getDiciplinTop5Team(Diciplin diciplin){
        switch (diciplin)
        ResultObject.getBestTimes()
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
