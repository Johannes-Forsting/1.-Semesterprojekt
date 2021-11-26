package dolphin;

import fileIO.Files;
import fileIO.ResultObject;
import foreman.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Diciplin {
    private String diciplinName;
    private boolean isBackCrawl = false;
    private boolean isCrawl = false;
    private boolean isButterfly = false;
    private boolean isBreastStroke = false;


    public Diciplin(String diciplinName) {
        this.diciplinName = diciplinName;

        if (diciplinName.equals("Backcrawl")) {
            this.isBackCrawl = true;
        }
        if (diciplinName.equals("Crawl")) {
            this.isCrawl = true;
        }
        if (diciplinName.equals("Butterfly")) {
            this.isButterfly = true;
        }
        if (diciplinName.equals("BreastStroke")) {
            this.isBreastStroke = true;
        }

    }

    public String getDiciplinName() {
        return this.diciplinName;
    }

    public ArrayList<String> getDiciplinResults(Diciplin diciplin) {
        ArrayList<String> resultsToPrint = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                for (int i = 0; i < Files.getCrawlResults().size(); i++) {
                    String line = Files.crawlScanner.nextLine();
                    String[] info = line.split(";");
                    String name = info[0];
                    String date = info[1];
                    String result = info[2];
                    resultsToPrint.add(name);
                    resultsToPrint.add(date);
                    resultsToPrint.add(result);
                }
                break;
            case "backcrawl":
                for (int i = 0; i < Files.getCrawlResults().size(); i++) {
                    String line = Files.backCrawlScanner.nextLine();
                    String[] info = line.split(";");
                    String name = info[0];
                    String date = info[1];
                    String result = info[2];
                    resultsToPrint.add(name);
                    resultsToPrint.add(date);
                    resultsToPrint.add(result);
                }
                break;
            case "breaststroke":
                for (int i = 0; i < Files.getCrawlResults().size(); i++) {
                    String line = Files.breastStrokeScanner.nextLine();
                    String[] info = line.split(";");
                    String name = info[0];
                    String date = info[1];
                    String result = info[2];
                    resultsToPrint.add(name);
                    resultsToPrint.add(date);
                    resultsToPrint.add(result);
                }
                break;
            case "butterfly":
                for (int i = 0; i < Files.getCrawlResults().size(); i++) {
                    String line = Files.butterflyScanner.nextLine();
                    String[] info = line.split(";");
                    String name = info[0];
                    String date = info[1];
                    String result = info[2];
                    resultsToPrint.add(name);
                    resultsToPrint.add(date);
                    resultsToPrint.add(result);
                }
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return resultsToPrint;
    }

    public ArrayList<ResultObject> getDiciplinBestTimes(Diciplin diciplin) {
        //ArrayList<ResultObject> diciplinBestTimes = new ArrayList<ResultObject>(crawl.getBestTimes(crawl.crawlResultObjectCreater()););
        ArrayList<ResultObject> diciplinBestTimes = new ArrayList<ResultObject>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                ResultObject crawl = new ResultObject();
                crawl.getBestTimes(crawl.crawlResultObjectCreater());
//virker ikke men skal cirka være sådan her-----------------------------------------------------------------------------------
                diciplinBestTimes = new ArrayList<ResultObject>(crawl.getBestTimes(crawl.crawlResultObjectCreater()));
                break;
            case "backcrawl":
                ResultObject backCrawl = new ResultObject();
                backCrawl.getBestTimes(backCrawl.backCrawlResultObjectCreater());
                break;
            case "breaststroke":
                ResultObject breastStroke = new ResultObject();
                breastStroke.getBestTimes(breastStroke.breastStrokeResultObjectCreater());
                break;
            case "butterfly":
                ResultObject butterfly = new ResultObject();
                butterfly.getBestTimes(butterfly.butterflyResultObjectCreater());
                break;
            default:
                System.out.println("No results found");
                break;
        }
        return diciplinBestTimes;
    }

    public boolean isBackCrawl() {
        return isBackCrawl;
    }

    public boolean isCrawl() {
        return isCrawl;
    }

    public boolean isButterfly() {
        return isButterfly;
    }

    public boolean isBreastStroke() {
        return isBreastStroke;
    }
}
