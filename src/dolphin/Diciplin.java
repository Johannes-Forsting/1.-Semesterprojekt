package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;

import java.util.ArrayList;
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

    public ArrayList<ResultObject> getDiciplinBestTimes(Diciplin diciplin) {
        ArrayList<ResultObject> diciplinBestTimes = new ArrayList<ResultObject>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                ResultObject crawl = new ResultObject();
                crawl.getBestTimes(crawl.crawlResultObjectCreater());
                diciplinBestTimes = new ArrayList<ResultObject>(crawl.getBestTimes(crawl.crawlResultObjectCreater()));
                break;
            case "backcrawl":
                ResultObject backCrawl = new ResultObject();
                backCrawl.getBestTimes(backCrawl.backCrawlResultObjectCreater());
                diciplinBestTimes = new ArrayList<ResultObject>(backCrawl.getBestTimes(backCrawl.backCrawlResultObjectCreater()));
                break;
            case "breaststroke":
                ResultObject breastStroke = new ResultObject();
                breastStroke.getBestTimes(breastStroke.breastStrokeResultObjectCreater());
                diciplinBestTimes = new ArrayList<ResultObject>(breastStroke.getBestTimes(breastStroke.breastStrokeResultObjectCreater()));
                break;
            case "butterfly":
                ResultObject butterfly = new ResultObject();
                butterfly.getBestTimes(butterfly.butterflyResultObjectCreater());
                diciplinBestTimes = new ArrayList<ResultObject>(butterfly.getBestTimes(butterfly.butterflyResultObjectCreater()));
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return diciplinBestTimes;
    }
}
