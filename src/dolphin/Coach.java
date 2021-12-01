package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;
import foreman.Foreman;

import java.util.ArrayList;
import java.util.Scanner;

import static dolphin.Team.teams;
import static foreman.Main.*;

public class Coach {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Foreman.getMembers();
        ResultObject.createAllResultObjects();

        makeNewTeam();
        makeNewTeam();

        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i));
        }

    }



    public static ArrayList<Member> getTop5Members(Diciplin diciplin, Boolean isSenior) {
        String diciplinName = diciplin.getDiciplinName();
        int currentResultListSize = 0;
        switch (diciplinName.toLowerCase()){
            case "crawl":
                currentResultListSize = ResultObject.crawlResults.size();
                break;
            case "backcrawl":
                currentResultListSize = ResultObject.backCrawlResults.size();
                break;
            case "breaststroke":
                currentResultListSize = ResultObject.breastStrokeResults.size();
                break;
            case "butterfly":
                currentResultListSize = ResultObject.butterflyResults.size();
                break;
            default:
                System.out.println("Results not loaded");
                break;
        }

        ArrayList<Member> membersForTop5Team = new ArrayList<>();
        for (int i = 0; i < currentResultListSize-1; i++) {
            int resultId = diciplin.getDiciplinResults(diciplin).get(i).getMemberId();
            for (int j = 0; j < Foreman.members.size(); j++) {
                if (Foreman.members.get(j).getMemberID() == resultId) {
                    if (isSenior) {
                        if (Foreman.members.get(j).getMemberAge() > 17) {
                            membersForTop5Team.add(Foreman.members.get(j));
                        } else {
                            break;
                        }
                    } else {
                        if (Foreman.members.get(j).getMemberAge() < 18) {
                            membersForTop5Team.add(Foreman.members.get(j));
                        } else {
                            break;
                        }
                    }
                }
            }
            if (membersForTop5Team.size() == 5) {
                break;
            }
        }
        return membersForTop5Team;
    }



    public static Diciplin chooseDiciplin() {
        System.out.println("What diciplin would you like to choose? \n - type \n'1': crawl\n'2': backcrawl\n'3': butterfly\n'4'breaststroke");
        switch (scanner.nextInt()) {
            case 1:
                return crawl;
            case 2:
                return backCrawl;
            case 3:
                return butterFly;
            case 4:
                return breastStroke;
            default:
                System.out.println("Invalid diciplin chosen");
                return null;
        }
    }

    public static void makeNewTeam() {
        Factory factoryPattern = new Factory();
        System.out.println("Enter the name of the team");
        String teamName = scanner.nextLine();
        System.out.println("Is team Senior\n - type 'y' for yes or 'n' for no:");
        String isSeniorString = scanner.nextLine();
        boolean isSenior;
        if (isSeniorString == "y") {
            isSenior = true;
        } else {
            isSenior = false;
        }
        Diciplin chosendiciplin = chooseDiciplin();
        ArrayList<Member> membersForTeam = getTop5Members(chosendiciplin, isSenior);
        Team newTeam = factoryPattern.makeNewTeam(teamName, chosendiciplin, isSenior, membersForTeam);
        teams.add(newTeam);
        System.out.println("The team is created ");
        String bufferline = scanner.nextLine();
    }
}
