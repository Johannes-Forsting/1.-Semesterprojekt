package foreman;

import dolphin.*;
import fileIO.FilesCashier;
import fileIO.FilesForeman;
import program.Validators;
import java.util.ArrayList;
import java.util.Scanner;

import static dolphin.Competition.competitions;
import static dolphin.Member.members;

public class Foreman {


    


    private static Scanner scanner = new Scanner(System.in);

    public static void foremanOptions(){
        boolean whileCondition = true;
        while (whileCondition){
            callOptions();
            int choice = Validators.validateUserIntInput(1, 10);
            switch (choice){
                case 1:
                    makeNewMember();
                    break;
                case 2:
                    callAllMembers();
                    break;
                case 3:
                    showCompetition();
                    break;
                case 4:
                    makeNewCompetition();
                    break;
                case 5:
                    changeCompetetiveStatus();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void getMembers(){
        members = FilesForeman.getMembersFromFile();
    }



    public static void callAllMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
    }



   public static void showCompetition(){
       competitions = FilesForeman.readCompetitionFile();
       for (int i = 0; i < competitions.size(); i++) {
           System.out.println(competitions.get(i));
       }
   }



    public static void makeNewCompetition(){
        Factory factory = new Factory();
        Diciplin diciplin = Validators.getDiciplin();
        System.out.println("Is competition for senior \n yes or no?");
        boolean isSenior = Validators.validateBooleanInput();
        System.out.println("enter a place");
        String place = scanner.nextLine();
        System.out.println("Enter a start point for the competition");
        String time = scanner.nextLine();
        ArrayList<Team> competingTeams = Competition.getTeamFromDiciplin(diciplin, isSenior);

        Competition newCompetition = factory.makeNewCompetition(diciplin, isSenior, place, time, competingTeams);
        competitions.add(newCompetition);
        FilesForeman.saveCompetitionInFile(newCompetition);

    }

    public static void makeNewMember(){
        GUI gui = new GUI();
    }

    private static void callOptions(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: Make new member.");
        System.out.println("Press 2 for: See all members");
        System.out.println("Press 3 for: See all competitions");
        System.out.println("Press 4 for: Make new competition");
        System.out.println("Press 5 for: Change competetive status of a member.");
        System.out.println("Press 9 for: Quit program.");
    }


    private static void changeCompetetiveStatus(){
        boolean booleanChoice;
        Member currentMember = members.get(0);
        System.out.println("What is the ID of the member you want to edit status on?");
        int choice = scanner.nextInt();
        for (int i = 0; i < members.size(); i++) {
            currentMember = members.get(i);
            if(choice == currentMember.getMemberID()){
                break;
            }
        }
        System.out.println(currentMember);
        System.out.println(currentMember.isActive());
        if (currentMember.isCompetitive() == true){
            System.out.println("This member is currently competetive. Would you like to revert that?");
            booleanChoice = Validators.validateBooleanInput();
            if (booleanChoice == true){
                currentMember.setCompetitive(false);
                currentMember.setDiciplin(null);
                FilesCashier.uploadAllMembers();
            }
            else {
                System.out.println("Alright. I have changed nothing.");
            }
        }
        else{
            System.out.println("This member is currently not competetive. Would you like to revert that?");
            booleanChoice = Validators.validateBooleanInput();
            if (booleanChoice == true){
                currentMember.setCompetitive(true);
                currentMember.setDiciplin(Validators.getDiciplin());
                FilesCashier.uploadAllMembers();
            }
            else {
                System.out.println("Alright. I have changed nothing.");
            }
        }
    }

}
