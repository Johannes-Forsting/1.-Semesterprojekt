package fileIO;

import java.util.ArrayList;

public class ResultObject {

    private String name;
    private String date;
    private String result;

    public ResultObject(String name, String date, String result) {
        this.name = name;
        this.date = date;
        this.result = result;
    }
    //Overload på constructor, så vi kan lave objektinstanser til metodekald uden at skulle angive parametre.
    public ResultObject() {
    }

    public ArrayList<ResultObject> crawlResultObjectCreater(){
        ArrayList<ResultObject> results = new ArrayList<>();
        for (int i = 0; i < Files.getCrawlResults().size(); i++) {
            String[] info = Files.getCrawlResults().get(i).split(";");
            results.add( new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public ArrayList<ResultObject> backCrawlResultObjectCreater(){
        ArrayList<ResultObject> results = new ArrayList<>();
        for (int i = 0; i < Files.getBackCrawlResults().size(); i++) {
            String[] info = Files.getBackCrawlResults().get(i).split(";");
            results.add( new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public ArrayList<ResultObject> breastStrokeResultObjectCreater(){
        ArrayList<ResultObject> results = new ArrayList<>();
        for (int i = 0; i < Files.getBreastStrokeResults().size(); i++) {
            String[] info = Files.getBreastStrokeResults().get(i).split(";");
            results.add( new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public ArrayList<ResultObject> butterflyResultObjectCreater(){
        ArrayList<ResultObject> results = new ArrayList<>();
        for (int i = 0; i < Files.getButterflyResults().size(); i++) {
            String[] info = Files.getButterflyResults().get(i).split(";");
            results.add( new ResultObject(info[0], info[1], info[2]));
        }
        return results;
    }

    public ArrayList<ResultObject> getBestTimes(ArrayList<ResultObject> results) {
        results.sort(new resultSorter());
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
