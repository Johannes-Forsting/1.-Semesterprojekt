package fileIO;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Factory;
import dolphin.Member;
import foreman.Main;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilesCoach {
    static Scanner scanner = new Scanner(System.in);
    static File crawlFile = new File("src/resources/crawlResults.csv");
    static File backCrawlFile = new File("src/resources/backCrawlResults.csv");
    static File breastStrokeFile = new File("src/resources/breastStrokeResults.csv");
    static File butterflyFile = new File("src/resources/butterflyResults.csv");
    static File competitionFile = new File("src/resources/competitionResults.csv");
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


    public static ArrayList<String> getCrawlResults() {
        ArrayList<String> crawlResults = new ArrayList<>();
        while (crawlScanner.hasNext()) {
            String line = crawlScanner.nextLine();
            String[] info = line.split(";");
            String name = info[0];
            crawlResults.add(name);
            for (int i = 1; i < info.length; i++) {
                crawlResults.add(info[i]);
            }
        }
        return crawlResults;
    }

    public static ArrayList<String> getBackCrawlResults() {
        ArrayList<String> backCrawlResults = new ArrayList<>();
        while (backCrawlScanner.hasNext()) {
            String line = backCrawlScanner.nextLine();
            String[] info = line.split(";");
            String name = info[0];
            backCrawlResults.add(name);
            for (int i = 1; i < info.length; i++) {
                backCrawlResults.add(info[i]);
            }
        }
        return backCrawlResults;
    }

    public static ArrayList<String> getBreastStrokeResults() {
        ArrayList<String> breastStrokeResults = new ArrayList<>();
        while (breastStrokeScanner.hasNext()) {
            String line = breastStrokeScanner.nextLine();
            String[] info = line.split(";");
            String name = info[0];
            breastStrokeResults.add(name);
            for (int i = 1; i < info.length; i++) {
                breastStrokeResults.add(info[i]);
            }
        }
        return breastStrokeResults;
    }

    public static ArrayList<String> getButterflyResults() {
        ArrayList<String> butterflyResults = new ArrayList<>();
        while (butterflyScanner.hasNext()) {
            String line = butterflyScanner.nextLine();
            String[] info = line.split(";");
            String name = info[0];
            butterflyResults.add(name);
            for (int i = 1; i < info.length; i++) {
                butterflyResults.add(info[i]);
            }
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


    public static ArrayList<String> getMembersResults() {
        ArrayList<String> timeResults = new ArrayList<>();
        //Arraylist<ArrayList<String>> memberResults = new ArrayList<ArrayList<String>>();
        try {
            File r = new File("src/resources/results.csv");
            Scanner scanner = new Scanner(r);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(";");
                String name = info[0];
                timeResults.add(name);
                for (int i = 1; i < info.length; i++) {
                    timeResults.add(info[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return timeResults;
    }

public static void getDiciplinFromUser(){
    StringBuilder sb = new StringBuilder();

    System.out.println("Enter a diciplin");
    System.out.println("1 for back crawl\n 2 for crawl \n 3 for butterfly \n 4 for breaststroke");
    int choice = scanner.nextInt();

  if (choice == 1){
      sb.append("Back crawl");
  } else if (choice == 2){
      sb.append("Crawl");
      } else if (choice == 3){
      sb.append("Butter fly");
  }else if (choice == 4){
      sb.append("Breast stroke");
  }
}



    //public static void competition() {
//
      //  File file = new File("src/resources/tournament.csv");
       //Scanner scanner = new Scanner(file);
        //scanner.nextLine();
    //}
}




