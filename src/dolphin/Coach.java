package dolphin;

import fileIO.FilesCoach;
import fileIO.ResultObject;
import foreman.Foreman;

import java.util.ArrayList;
import java.util.Scanner;

import static foreman.Main.*;

public class Coach {


    private static Scanner scanner = new Scanner(System.in);
    static Factory factory = new Factory();

    public static void coachOptions(){
        boolean whileCondition = true;
        while (whileCondition){
            callOptionsCoach();
            Diciplin diciplin;
            int choice = validateUserIntInput(1, 10);
            switch (choice){
                case 1:
                    diciplin = chooseDiciplin();
                    System.out.println("Is the team senior?");
                    boolean isSenior = Foreman.validateBooleanInput();
                    ArrayList<Member> tmpTeamMembers = getTop5Members(diciplin, isSenior);
                    System.out.println("Do you want to add members to a team?");
                    boolean agreed = Foreman.validateBooleanInput();
                    String bufferline = scanner.nextLine();
                    if (agreed){
                        System.out.println("What would you like to name the team?");
                        String tmpTeamName = scanner.nextLine();
                        Team tmpTeam = factory.makeNewTeam(tmpTeamName, diciplin, isSenior, tmpTeamMembers);
                        FilesCoach.generateNewTeam(tmpTeam);
                        FilesCoach.uploadMembersToTeamFile(tmpTeam);
                    }
                    break;
                case 2:
                    diciplin = chooseDiciplin();
                    System.out.println(diciplin.getDiciplinResults(diciplin).toString());
                    break;
                case 3:
                    //add member to team


                    break;
                case 4:
                    break;
                case 5:
                    Foreman.makeNewCompetition();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void callOptionsCoach(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: Show top 5 members.");
        System.out.println("Press 2 for: See all results");
        System.out.println("Press 3 for: Add new result");
        System.out.println("Press 4 for: Create team");
        System.out.println("Press 9 for: Exit / Shut down");
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
                            if (membersForTop5Team.contains(Foreman.members.get(j))){
                            break;
                            }
                            membersForTop5Team.add(Foreman.members.get(j));
                            System.out.println(Foreman.members.get(j));
                            System.out.println(diciplin.getDiciplinResults(diciplin).get(i).getResult());
                        } else {
                            break;
                        }
                    } else {
                        if (Foreman.members.get(j).getMemberAge() < 18) {
                            //check if member already in top 5
                            if (membersForTop5Team.contains(Foreman.members.get(j))){
                                break;
                            }
                            membersForTop5Team.add(Foreman.members.get(j));
                            System.out.println(Foreman.members.get(j));
                            System.out.println(diciplin.getDiciplinResults(diciplin).get(i).getResult());
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
}
