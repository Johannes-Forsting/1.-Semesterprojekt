package dolphin;

import fileIO.ResultObject;

import java.util.ArrayList;

import static fileIO.ResultObject.*;
import static foreman.Main.*;

public class Diciplin {
    private String diciplinName;

    public Diciplin(String diciplinName) {
        this.diciplinName = diciplinName;
    }

    @Override
    public String toString() {
        return  diciplinName;
    }

    public String getDiciplinName() {
        return this.diciplinName;
    }

    public ArrayList<ResultObject> getDiciplinResults(Diciplin diciplin) {
        ArrayList<ResultObject> resultsToPrint = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                resultsToPrint = new ArrayList<>(crawlResults);
                break;
            case "backcrawl":
                resultsToPrint = new ArrayList<>(backCrawlResults);
                break;
            case "breaststroke":
                resultsToPrint = new ArrayList<>(breastStrokeResults);
                break;
            case "butterfly":
                resultsToPrint = new ArrayList<>(butterflyResults);
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return resultsToPrint;
    }

    /*public static ArrayList<ResultObject> getSortedDiciplinResults(Diciplin diciplin) {
        ArrayList<ResultObject> sortedDiciplinResults = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                sortedDiciplinResults = ResultObject.sortResults(crawlResults);
                break;
            case "backcrawl":
                sortedDiciplinResults = ResultObject.sortResults(backCrawlResults);
                break;
            case "breaststroke":
                sortedDiciplinResults = ResultObject.sortResults(breastStrokeResults);
                break;
            case "butterfly":
                sortedDiciplinResults = ResultObject.sortResults(butterflyResults);
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return sortedDiciplinResults;
    }

     */
}
