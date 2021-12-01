package fileIO;

import dolphin.Diciplin;

import java.util.ArrayList;

import static fileIO.FilesCoach.*;
import static foreman.Main.*;
import static foreman.Main.butterFly;

public class ResultObject {

    private String name;
    private String result;
    private String date;
    private int memberId;
    public static ArrayList<ResultObject> crawlResults = new ArrayList<>();
    public static ArrayList<ResultObject> backCrawlResults = new ArrayList<>();
    public static ArrayList<ResultObject> breastStrokeResults = new ArrayList<>();
    public static ArrayList<ResultObject> butterflyResults = new ArrayList<>();


    public ResultObject(String name, String result, String date, int memberId) {
        this.name = name;
        this.result = result;
        this.date = date;
        this.memberId = memberId;
    }

    //Overload på constructor, så vi kan lave objektinstanser til metodekald uden at skulle angive parametre.
    public ResultObject() {
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                ", date='" + date + '\'' +
                ", memberId=" + memberId +
                '}';
    }

    public static void createAllResultObjects(){
        resultObejctCreater(crawl);
        resultObejctCreater(backCrawl);
        resultObejctCreater(breastStroke);
        resultObejctCreater(butterFly);
    }

    private static ArrayList<ResultObject> resultObejctCreater(Diciplin diciplin){
        switch (diciplin.getDiciplinName().toLowerCase()){
            case "crawl":
                String crawlscannerbufferline = crawlScanner.nextLine();
                while (crawlScanner.hasNextLine()) {
                    String line = crawlScanner.nextLine();
                    String[] info = collectInfoFromScanner(line);
                    crawlResults.add(new ResultObject(info[0], info[1], info[2], Integer.parseInt(info[3])));
                }
                crawlResults.sort(new resultSorter().reversed());
                return crawlResults;
            case "backcrawl":
                String backcrawlscannerbufferline = backCrawlScanner.nextLine();
                while (backCrawlScanner.hasNext()) {
                    String line = backCrawlScanner.nextLine();
                    String[] info = collectInfoFromScanner(line);
                    backCrawlResults.add(new ResultObject(info[0], info[1], info[2], Integer.parseInt(info[3])));
                }
                backCrawlResults.sort(new resultSorter().reversed());
                return backCrawlResults;
            case "breaststroke":
                String breststrokebufferline = breastStrokeScanner.nextLine();
                while (breastStrokeScanner.hasNext()) {
                    String line = breastStrokeScanner.nextLine();
                    String[] info = collectInfoFromScanner(line);
                    breastStrokeResults.add(new ResultObject(info[0], info[1], info[2], Integer.parseInt(info[3])));
                }
                breastStrokeResults.sort(new resultSorter().reversed());
                return breastStrokeResults;
            case "butterfly":
                String bufferline = butterflyScanner.nextLine();
                while (butterflyScanner.hasNext()) {
                    String line = butterflyScanner.nextLine();
                    String[] info = collectInfoFromScanner(line);
                    butterflyResults.add(new ResultObject(info[0], info[1], info[2], Integer.parseInt(info[3])));
                }
                butterflyResults.sort(new resultSorter().reversed());
                return butterflyResults;
            default:
                return null;
        }
    }

    public static ArrayList<ResultObject> sortResults(ArrayList<ResultObject> results) {
        results.sort(new resultSorter().reversed());
        return results;
    }


    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getDate() {
        return date;
    }

    public String getResult() {
        return result;
    }
}