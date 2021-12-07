package dolphin;

import fileIO.ResultObject;
import java.util.ArrayList;
import static fileIO.ResultObject.*;

public class Diciplin {
    private String diciplinName;
    public static Diciplin backCrawl = new Diciplin("Backcrawl");
    public static Diciplin crawl = new Diciplin("Crawl");
    public static Diciplin butterFly = new Diciplin("Butterfly");
    public static Diciplin breastStroke = new Diciplin("Breaststroke");


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

}
