package fileIO;

import dolphin.Coach;
import foreman.Foreman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesCoach {
    static Scanner scanner = new Scanner(System.in);
    static File crawlFile = new File("src/resources/results/crawlResults.csv");
    static File backCrawlFile = new File("src/resources/results/backCrawlResults.csv");
    static File breastStrokeFile = new File("src/resources/results/breastStrokeResults.csv");
    static File butterflyFile = new File("src/resources/results/butterflyResults.csv");
    static File competitionFile = new File("src/resources/results/competitionResults.csv");
    public static Scanner crawlScanner;
    public static Scanner backCrawlScanner;
    public static Scanner breastStrokeScanner;
    public static Scanner butterflyScanner;
    public static Scanner competitionScanner;

    static {
        try {
            crawlScanner = new Scanner(crawlFile);
            backCrawlScanner = new Scanner(backCrawlFile);
            breastStrokeScanner = new Scanner(breastStrokeFile);
            butterflyScanner = new Scanner(butterflyFile);
            competitionScanner = new Scanner(competitionFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String[] collectInfoFromScanner(String line){
        String[] info = line.split(";");
        return info;
    }


    public static ArrayList<String> getCrawlResults() {
        ArrayList<String> crawlResults = new ArrayList<>();
        while (crawlScanner.hasNext()) {
            String line = crawlScanner.nextLine();
            collectInfoFromScanner(line);

        }
        return crawlResults;
    }

    public static ArrayList<ResultObject> getBackCrawlResults() {
        ArrayList<ResultObject> backCrawlResults = new ArrayList<>();
        while (backCrawlScanner.hasNext()) {
            String line = backCrawlScanner.nextLine();
            collectInfoFromScanner(line);
        }
        return backCrawlResults;
    }

    public static ArrayList<ResultObject> getBreastStrokeResults() {
        ArrayList<ResultObject> breastStrokeResults = new ArrayList<>();
        while (breastStrokeScanner.hasNext()) {
            String line = breastStrokeScanner.nextLine();
            collectInfoFromScanner(line);
        }
        return breastStrokeResults;
    }

    public static ArrayList<ResultObject> getButterflyResults() {
        ArrayList<ResultObject> butterflyResults = new ArrayList<>();
        while (butterflyScanner.hasNext()) {
            String line = butterflyScanner.nextLine();
            collectInfoFromScanner(line);
        }
        return butterflyResults;
    }
        //needs fixing maybe too early to implement this method
    public static ArrayList<String> getCompetitionResults() {
        ArrayList<String> competitionResults = new ArrayList<>();
        while (competitionScanner.hasNext()) {
            String line = competitionScanner.nextLine();
            String[] info = line.split(";");
            String name = info[0];
            competitionResults.add(name);
            for (int i = 1; i < info.length; i++) {
                competitionResults.add(info[i]);
            }
        }
        return competitionResults;
    }

    public static void generateNewTeam() {
        System.out.println("Give your team file a name");
        System.out.println("Enter done when your file is finished");

        while (true) {
            String name = "src/resources/teams/";
            name += scanner.nextLine();
            name += ".csv";
            if (name.equals("src/resources/teams/done.csv")) {
                break;
            }

            try {
                PrintWriter newFile = new PrintWriter(name);
                StringBuilder sb = new StringBuilder();
                sb.append("Team name");
                sb.append(";");
                sb.append("Diciplin");
                sb.append(";");
                sb.append("Senior");
                sb.append("\n");


                System.out.println("Enter a team name");
                sb.append(scanner.nextLine());
                sb.append(";");
                sb.append(Coach.chooseDiciplin().getDiciplinName());
                sb.append(";");
                System.out.println("Senior? yes or no?");
                sb.append(Foreman.validateBooleanInput());



                newFile.write(sb.toString());
                newFile.close();
                System.out.println("your team is created!");

            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                e.printStackTrace();
            }
        }
    }
}




