package coach;

import dolphin.*;
import fileIO.FilesCoach;
import fileIO.FilesForeman;
import fileIO.ResultObject;
import foreman.Foreman;
import program.Validators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static foreman.Foreman.*;


public class Coach {


    private static Scanner scanner = new Scanner(System.in);
    static Factory factory = new Factory();

    public static void coachOptions(){
        boolean whileCondition = true;
        while (whileCondition){
            callOptionsCoach();
            Diciplin diciplin;
            int choice = Validators.validateUserIntInput(1, 10);
            switch (choice){
                case 1:
                    diciplin = Validators.getDiciplin();
                    System.out.println("Is the team senior?");
                    boolean isSenior = Validators.validateBooleanInput();
                    ArrayList<Member> tmpTeamMembers = getTop5Members(diciplin, isSenior);
                    System.out.println("Do you want to add members to a team?");
                    boolean agreed = Validators.validateBooleanInput();
                    if (agreed){
                        System.out.println("What would you like to name the team?");
                        String tmpTeamName = scanner.nextLine();
                        Team tmpTeam = factory.makeNewTeam(tmpTeamName, diciplin, isSenior, tmpTeamMembers);
                        FilesCoach.generateNewTeam(tmpTeam);
                        FilesCoach.uploadMembersToTeamFile(tmpTeam);

                        System.out.println("Would you like to add this team to a competition?");
                        agreed = Validators.validateBooleanInput();
                        if (agreed){
                            addTeamToCompetition(tmpTeam);
                        }
                    }
                    break;
                case 2:
                    diciplin = Validators.getDiciplin();
                    System.out.println(diciplin.getDiciplinResults(diciplin).toString());
                    break;
                case 3:
                    addNewResult();
                    break;
                case 4:
                    Foreman.showCompetitions();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void addTeamToCompetition(Team team){
        ArrayList<Competition> tmpCompetitions = new ArrayList<>();
        Diciplin tmpDiciplin = team.getDiciplin();
        boolean tmpIsSenior = team.isSenior();
        for (int i = 0; i < competitions.size(); i++) {
            boolean condition1 = competitions.get(i).isSenior() == true && tmpIsSenior == true;
            boolean condition2 = competitions.get(i).getDiciplin() == tmpDiciplin;
            boolean condition3 = competitions.get(i).getCompetingTeam() == null ? true : false;
            if (condition1 && condition2 && condition3){
                tmpCompetitions.add(competitions.get(i));
            }
        }
        for (int i = 0; i < tmpCompetitions.size(); i++) {
            System.out.println((i + 1) + " " + tmpCompetitions.get(i));
        }
        System.out.println("Which of the following competitions above would you like to add the team to?");
        int choice = Validators.validateUserIntInput(1, tmpCompetitions.size());
        for (int i = 0; i < tmpCompetitions.size(); i++) {
            if (choice == (i + 1)){
                tmpCompetitions.get(i).setCompetingTeam(team);
            }
        }
        FilesCoach.uploadAllCompetitions();
    }

    public static void addNewResult(){
        String resultToAdd;
        System.out.println("What is the time of the result:\n HH:MM");
        String timeToAdd = scanner.nextLine();
        System.out.println("What date was the result set: \n DD-MM-YYYY");
        String dateOfResult = scanner.nextLine();
        System.out.println("What is the member ID of the result");
        int memberId = scanner.nextInt();
        String memberName = FilesCoach.getMemberNameFromMemberId(memberId);
        resultToAdd = memberName + ";" + timeToAdd + ";" + dateOfResult + ";" + memberId;
        String bufferline = scanner.nextLine();
        System.out.println("What diciplin is the result set in\n 1 - crawl \n 2 - backcrawl \n 3 - breastStroke \n 4 - butterfly");
        int chosenDiciplinInt = scanner.nextInt();
        if(chosenDiciplinInt == 1){
            FilesCoach.addNewResult(crawl,resultToAdd);
        } else if(chosenDiciplinInt == 2){
            FilesCoach.addNewResult(backCrawl,resultToAdd);
        }else if(chosenDiciplinInt == 3){
            FilesCoach.addNewResult(breastStroke,resultToAdd);
        }else if(chosenDiciplinInt == 4){
            FilesCoach.addNewResult(butterFly,resultToAdd);
        } else {
            System.out.println("Invalid diciplin");
        }
        System.out.println("Result added");


    }

    public static void callOptionsCoach(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: Show top 5 members... And add to team");
        System.out.println("Press 2 for: See all results");
        System.out.println("Press 3 for: Add new result");
        System.out.println("Press 4 for: See all competitions");
        System.out.println("Press 9 for: Quit program");
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

}
