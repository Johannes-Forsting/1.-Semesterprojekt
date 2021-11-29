package fileIO;

import java.util.ArrayList;

import static fileIO.FilesCoach.*;

public class ResultObject {

    private String name;
    private String result;
    private String date;
    public static ArrayList<ResultObject> results = new ArrayList<>();

    public ResultObject(String name, String result, String date) {
        this.name = name;
        this.result = result;
        this.date = date;
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
                '}';
    }

    public static ArrayList<ResultObject> crawlResultObjectCreater() {
            while (crawlScanner.hasNextLine()) {
                String line = crawlScanner.nextLine();
                String[] info = collectInfoFromScanner(line);
                results.add(new ResultObject(info[0], info[1], info[2]));
            }
        return results;
    }

    public static ArrayList<ResultObject> backCrawlResultObjectCreater() {
        ArrayList<ResultObject> results = new ArrayList<>();
        while (backCrawlScanner.hasNext()) {
            String line = backCrawlScanner.nextLine();
            String[] info = collectInfoFromScanner(line);
            results.add(new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public static ArrayList<ResultObject> breastStrokeResultObjectCreater() {
        ArrayList<ResultObject> results = new ArrayList<>();
        while (breastStrokeScanner.hasNext()) {
            String line = breastStrokeScanner.nextLine();
            String[] info = collectInfoFromScanner(line);
            results.add(new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public static ArrayList<ResultObject> butterflyResultObjectCreater() {
        ArrayList<ResultObject> results = new ArrayList<>();
        while (butterflyScanner.hasNext()) {
            String line = butterflyScanner.nextLine();
            String[] info = collectInfoFromScanner(line);
            results.add(new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public static ArrayList<ResultObject> getBestTimes(ArrayList<ResultObject> results) {
        results.sort(new resultSorter().reversed());
        ArrayList<ResultObject> bestTimes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bestTimes.add(results.get(i));
        }
        return bestTimes;

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getResult() {
        return result;
    }
}