package fileIO;

import dolphin.Coach;
import dolphin.Diciplin;
import dolphin.Member;
import dolphin.Team;
import foreman.Foreman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static fileIO.FilesForeman.getMemberString;

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

    public static String[] collectInfoFromScanner(String line) {
        String[] info = line.split(";");
        return info;
    }

    public static void addNewResult(Diciplin diciplin, String resultToAdd) {
        switch (diciplin.getDiciplinName().toLowerCase()) {
            case "crawl":
                try (FileWriter fw = new FileWriter("src/resources/results/crawlResults.csv", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println("\n" + resultToAdd);
                } catch (IOException e) {
                }
                break;
            case "backcrawl":
                try (FileWriter fw = new FileWriter("src/resources/results/backCrawlResults.csv", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(resultToAdd);
                } catch (IOException e) {
                }
                break;
            case "breaststroke":
                try (FileWriter fw = new FileWriter("src/resources/results/breastStrokeResults.csv", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(resultToAdd);
                } catch (IOException e) {
                }
                break;
            case "butterfly":
                try (FileWriter fw = new FileWriter("src/resources/results/butterflyResults.csv", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(resultToAdd);
                } catch (IOException e) {
                }
                break;
            default:
                System.out.println("Invalid diciplin");
                break;
        }
    }
    public static String getMemberNameFromMemberId(int id){
        for (int i = 0; i < Foreman.members.size(); i++) {
            Member currentMember = Foreman.members.get(i);
            if(id == currentMember.getMemberID()){
                return currentMember.getName();
            } else {
                return "MemberName Not found";
            }
    }
        return null;
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

    public static void uploadMembersToTeamFile(Team team) {
        for (int i = 0; i < team.getContestants().size(); i++) {
            Member tmpMember = team.getContestants().get(i);
            String memberToString = getMemberString(tmpMember);
            String filepath = "src/resources/teams/" + team.getTeamName() + ".csv";
            try (FileWriter fw = new FileWriter(filepath, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(memberToString);
            } catch (IOException e) {

            }
        }
    }


    public static void generateNewTeam(Team newTeam) {
        String name = "src/resources/teams/" + newTeam.getTeamName() + ".csv";
        try {
            PrintWriter newFile = new PrintWriter(name);
            StringBuilder sb = new StringBuilder();
            sb.append("Team name;Diciplin;Senior\n");
            sb.append(newTeam.getTeamName());
            sb.append(";");
            sb.append(newTeam.getDiciplin());
            sb.append(";");
            sb.append(newTeam.isSenior());
            sb.append("\n");
            newFile.write(sb.toString());
            newFile.close();
            System.out.println("your team is created!");

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }


    //public static void competition() {
//
    //  File file = new File("src/resources/tournament.csv");
    //Scanner scanner = new Scanner(file);
    //scanner.nextLine();
    //}
}




