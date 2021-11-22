package dolphin;

import java.util.ArrayList;

public class Team {
        private String name;
        private ArrayList<Double> results;
        private ArrayList<Member> contestants;
        private ArrayList<Double> bestTimes;

    public Team(String name, ArrayList<Member> contestants) {
        this.name = name;
        this.contestants = contestants;
    }

    public void setContestantsResults(ArrayList results, Member member) {
        int indexOfContestantResult = member.getMemberId();
        //some shit thats not working == member.setSwimmingResults(results.get(indexOfContestantResult));
        //then members will have setPR, and method call from here.
        this.results = results;
    }

    public void setResults(/*resultsfrom file, */){
        //reads file, and add results by memberId and time accordingly

    }

    public ArrayList<Double> updateBestTimes() {
        return bestTimes;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public ArrayList<Member> getContestants() {
        return contestants;
    }
}
