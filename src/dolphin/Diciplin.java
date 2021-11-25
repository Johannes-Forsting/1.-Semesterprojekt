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

    public ArrayList<String> getDiciplinBestTimes(Diciplin diciplin){
        ArrayList<String> bestTimes = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":


                for (int i = 2; i < diciplin.getDiciplinResults(diciplin).size(); i+=3) {
                    bestTimes.add(diciplin.getDiciplinResults(diciplin).get(i));
                    times.add(diciplin.getDiciplinResults(diciplin).get(i));
                }
                int[] resultIndexes = new int[bestTimes.size()];
                for (int i = 0; i < bestTimes.size(); i++) {
                    //jeg laver et index array for at kunne referere tilbage til placeringen af best time
                    resultIndexes[i] = bestTimes.indexOf(diciplin.getDiciplinResults(diciplin).get(i));
                }
                times.removeAll(Collections.singleton(":"));
                Collections.sort(times);



                //(n+1)*3 for refind index of name

                String name = info[0];
                String date = info[1];
                String result = info[2];
                resultsToPrint.add(name);
                resultsToPrint.add(date);
                resultsToPrint.add(result);
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
