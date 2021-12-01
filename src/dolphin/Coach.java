package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;
import foreman.Foreman;

import java.util.ArrayList;
import java.util.Scanner;

import static dolphin.Team.teams;
import static foreman.Main.*;

public class Coach {
    public static ArrayList<ResultObject> bestResults = new ArrayList<fileIO.ResultObject>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Foreman.getMembers();
        System.out.println(getTop5Members(crawl, true));
        //makeNewTeam();
       //System.out.println(teams);
    }



    public static ArrayList<Member> getTop5Members(Diciplin diciplin, Boolean isSenior) {
        ResultObject.resultObejctCreater(diciplin);
        System.out.println("virker dette?");
        ArrayList<Member> membersForTop5Team = new ArrayList<>();
        ArrayList<ResultObject> currentresults = Diciplin.getSortedDiciplinResults(diciplin);
        for (int i = 0; i < currentresults.size(); i++) {
            int resultId = currentresults.get(i).getMemberId();
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

    static void makeNewTeam() {
        Factory factoryPattern = new Factory();
        System.out.println("Enter the name of the team");
        String teamName = "zandooo"; //scanner.nextLine();
        System.out.println("Is team Senior\n - type 'y' for yes or 'n' for no:");
        String isSeniorString = "y"; //scanner.nextLine();
        boolean isSenior;
        if (isSeniorString == "y") {
            isSenior = true;
        } else {
            isSenior = false;
        }
        //Diciplin chosendiciplin = chooseDiciplin();
        ArrayList<Member> membersForTeam = getTop5Members(crawl, isSenior);
        Team newTeam = factoryPattern.makeNewTeam(teamName, crawl, isSenior, membersForTeam);
        teams.add(newTeam);
    }
}
