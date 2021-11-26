package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;

import java.util.ArrayList;
import java.util.Collections;

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

    private ArrayList<String> collectInfoFromScanner(ArrayList<String> resultsToPrint, String line){
        String[] info = line.split(";");
        String name = info[0];
        String date = info[1];
        String result = info[2];
        resultsToPrint.add(name);
        resultsToPrint.add(date);
        resultsToPrint.add(result);
        return resultsToPrint;
    }

    public ArrayList<String> getDiciplinResults(Diciplin diciplin) {
        ArrayList<String> resultsToPrint = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                for (int i = 0; i < FilesCoach.getCrawlResults().size(); i++) {
                    String line = FilesCoach.crawlScanner.nextLine();
                    collectInfoFromScanner(resultsToPrint, line);
                }
                break;
            case "backcrawl":
                for (int i = 0; i < FilesCoach.getCrawlResults().size(); i++) {
                    String line = FilesCoach.backCrawlScanner.nextLine();
                    collectInfoFromScanner(resultsToPrint, line);
                }
                break;
            case "breaststroke":
                for (int i = 0; i < FilesCoach.getCrawlResults().size(); i++) {
                    String line = FilesCoach.breastStrokeScanner.nextLine();
                    collectInfoFromScanner(resultsToPrint, line);
                }
                break;
            case "butterfly":
                for (int i = 0; i < FilesCoach.getCrawlResults().size(); i++) {
                    String line = FilesCoach.butterflyScanner.nextLine();
                    collectInfoFromScanner(resultsToPrint, line);
                }
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
