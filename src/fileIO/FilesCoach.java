//Lavet af Johannes, Asger og Simon
package fileIO;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Member;
import dolphin.Team;
import java.io.*;
import java.util.Scanner;

import static fileIO.FilesForeman.getMemberString;

public class FilesCoach {

    //Scannere og filereaders for hver enkelt diciplin blevet initialiseret som satiske metode på klassen
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

    //metode som indtager en string fra en csv-fil og deler den op et array så hver enkelt element kan bruges hver for sig
    public static String[] collectInfoFromScanner(String line) {
        String[] info = line.split(";");
        return info;
    }

    //Metode som tilføjer et nyt result til csv-filerne afhængig af hvilken diciplin der er som parameter
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

    //Finder et medlemsnavn udfra et medlems ID
    public static String getMemberNameFromMemberId(int id){
        for (int i = 0; i < Member.members.size(); i++) {
            Member currentMember = Member.members.get(i);
            if(id == currentMember.getMemberID()){
                return currentMember.getName();
            } else {
                return "MemberName Not found";
            }
    }
        return null;
    }

    //Uploader medlemmer til en team-csv-fil
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

    //Opretter en ny -team-csv-fil.
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

    //Overskriver alle konkurrencer i csv-filen.
    public static void uploadAllCompetitions() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("src/resources/competitions/competition.csv"));
            writer.write("Diciplin;isSenior;Place;Time;team");
            for (int i = 0; i < Competition.competitions.size(); i++) {
                String convertStringToFile = FilesForeman.convertCompetitionToString(Competition.competitions.get(i));
                writer.write("\n" + convertStringToFile);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




