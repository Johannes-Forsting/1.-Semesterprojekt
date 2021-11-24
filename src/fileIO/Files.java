package fileIO;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Member;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Files {
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


    public static void addMemberToDatabase(Member newMember) {
        String memberToString = getMemberString(newMember);
        try (FileWriter fw = new FileWriter("src/resources/Members.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(memberToString);
        } catch (IOException e) {
        }
    }

    private static String getMemberString(Member member) {
        String stringToReturn = member.getName();
        stringToReturn += ";" + member.getDateOfBirth();
        stringToReturn += member.isActive() ? ";" + "yes" : ";" + "no";
        stringToReturn += member.isCompetitive() ? ";" + "yes" : ";" + "no";
        stringToReturn += ";" + member.getDiciplin();
        stringToReturn += ";" + "no";

        return stringToReturn;
    }


    public static ArrayList<Member> getMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            File f = new File("src/resources/Members.csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(";");
                String name = info[0];
                String date = info[1];
                boolean isActive = false;
                if (info[2].toLowerCase().equals("yes")) {
                    isActive = true;
                }
                boolean isCompetative = false;
                if (info[3].toLowerCase().equals("yes")) {
                    isCompetative = true;
                }
                Diciplin diciplin = new Diciplin(info[4]);
                boolean hasArrears = false;
                if (info[4].toLowerCase().equals("yes")) {
                    hasArrears = true;
                }
                Member currentMember = new Member(isCompetative, isActive, date, name, diciplin, hasArrears);
                members.add(currentMember);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return members;
    }


    //virker, men der skal ændres lidt i toString
    public static void generateNewCompetitionFile() {
        System.out.println("give your file a name");
        System.out.println("enter done when your file is finished");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = "src/resources/";
            name += scanner.nextLine();
            name += ".csv";
            if (name.equals("src/resources/done.csv")) {
                break;
            }

            try {
                PrintWriter newFile = new PrintWriter(name);
                StringBuilder sb = new StringBuilder();
                sb.append("Diciplin");
                sb.append(",");
                sb.append("Place");
                sb.append(",");
                sb.append("Time");
                sb.append("\n");

                System.out.println("Enter a diciplin ");
                sb.append(scanner.nextLine());
                sb.append(",");
                System.out.println("Enter a place");
                sb.append(scanner.nextLine());
                sb.append(",");
                System.out.println("Now enter a start time for the competition");
                sb.append(scanner.nextLine());

                newFile.write(sb.toString());
                newFile.close();
                System.out.println("your competition is created!");

            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                e.printStackTrace();
            }
        }
    }
}




