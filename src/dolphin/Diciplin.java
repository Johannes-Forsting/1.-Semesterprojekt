package dolphin;

import fileIO.ResultObject;

import java.util.ArrayList;

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
                resultsToPrint = new ArrayList<ResultObject>(ResultObject.crawlResultObjectCreater());
                break;
            case "backcrawl":
                resultsToPrint = new ArrayList<ResultObject>(ResultObject.backCrawlResultObjectCreater());
                break;
            case "breaststroke":
                resultsToPrint = new ArrayList<ResultObject>(ResultObject.breastStrokeResultObjectCreater());
                break;
            case "butterfly":
                resultsToPrint = new ArrayList<ResultObject>(ResultObject.butterflyResultObjectCreater());
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return resultsToPrint;
    }

    public static ArrayList<ResultObject> getSortedDiciplinResults(Diciplin diciplin) {
        ArrayList<ResultObject> sortedDiciplinResults = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                sortedDiciplinResults = ResultObject.sortResults(ResultObject.crawlResultObjectCreater());
                break;
            case "backcrawl":
                sortedDiciplinResults = ResultObject.sortResults(ResultObject.backCrawlResultObjectCreater());
                break;
            case "breaststroke":
                sortedDiciplinResults = ResultObject.sortResults(ResultObject.breastStrokeResultObjectCreater());
                break;
            case "butterfly":
                sortedDiciplinResults = ResultObject.sortResults(ResultObject.butterflyResultObjectCreater());
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return sortedDiciplinResults;
    }
}
