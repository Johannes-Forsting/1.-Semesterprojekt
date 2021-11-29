package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static fileIO.FilesCoach.collectInfoFromScanner;
import static fileIO.FilesCoach.crawlScanner;

public class Diciplin {
    private String diciplinName;
    private boolean isBackCrawl = false;
    private boolean isCrawl = false;
    private boolean isButterfly = false;
    private boolean isBreastStroke = false;


    public Diciplin(String diciplinName) {
        this.diciplinName = diciplinName;
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

    public static ArrayList<ResultObject> getDiciplinBestTimes(Diciplin diciplin) {
        ArrayList<ResultObject> diciplinBestTimes = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                diciplinBestTimes = ResultObject.getBestTimes(ResultObject.crawlResultObjectCreater());
                break;
            case "backcrawl":
                diciplinBestTimes = ResultObject.getBestTimes(ResultObject.backCrawlResultObjectCreater());
                break;
            case "breaststroke":
                diciplinBestTimes = ResultObject.getBestTimes(ResultObject.breastStrokeResultObjectCreater());
                break;
            case "butterfly":
                diciplinBestTimes = ResultObject.getBestTimes(ResultObject.butterflyResultObjectCreater());
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return diciplinBestTimes;
    }
}
