package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;
import foreman.Foreman;

import java.util.ArrayList;
import java.util.Scanner;

import static foreman.Main.*;

public class Coach {
    public static ArrayList<ResultObject> bestResults = new ArrayList<fileIO.ResultObject>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Foreman.getMembers();
        ArrayList<Member> seniortest = getTop5Members(breastStroke, true);
        for (int i = 0; i < seniortest.size(); i++) {
            System.out.println(seniortest.get(i));
        }
    }

    static Member getMemberwithId(int id) {
        ArrayList<Member> members = Foreman.members;
        for (int j = 0; j < members.size(); j++) {
            if (id == members.get(j).getMemberID()) {
                return members.get(j);
            }
        }
        return null;
    }

    static ArrayList<Member> getTop5Members(Diciplin diciplin, Boolean isSenior) {
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

    public void showResults() {
        for (int i = 0; i < bestResults.size(); i++) {
            System.out.println(bestResults.get(i));
        }
    }

    public void getResults() {
        bestResults = FilesCoach.getButterflyResults();
    }


    public void makeNewTeam() {
        Factory factoryPattern = new Factory();
        System.out.println("Enter the name of the team");
        String teamName = scanner.nextLine();

        //Team newTeam = factoryPattern.makeNewTeam(teamName);
        // bestResults.add(newTeam);
        FilesCoach.getBreastStrokeResults();

    }
}
