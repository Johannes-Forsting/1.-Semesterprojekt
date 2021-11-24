package dolphin;

import fileIO.Files;
import foreman.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Diciplin {
    private String diciplinName;
    private boolean isBackCrawl = false;
    private boolean isCrawl = false;
    private boolean isButterfly = false;
    private boolean isBreastStroke = false;



    public Diciplin(String diciplinName) {
        this.diciplinName = diciplinName;

        if (diciplinName.equals("Backcrawl")){
            this.isBackCrawl = true;
        }
        if (diciplinName.equals("Crawl")){
            this.isCrawl = true;
        }
        if (diciplinName.equals("Butterfly")){
            this.isButterfly = true;
        }
        if (diciplinName.equals("BreastStroke")){
            this.isBreastStroke = true;
        }

    }

    public String getDiciplinName(){
        return this.diciplinName;
    }

    public void getDiciplinResults(Diciplin diciplin){
        switch (diciplin.getDiciplinName().toLowerCase()){
            case "crawl":
                while(Files.crawlScanner.hasNext()){
                    for (int i = 0; i < Files.getCrawlResults().size(); i++) {

                    }
                }
            case "backcrawl":
            case "breaststroke":
            case "butterfly":
            default:

        }




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
