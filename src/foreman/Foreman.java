package foreman;

import dolphin.*;
import fileIO.FilesCashier;
import fileIO.FilesForeman;
import program.Validators;
import java.util.Scanner;
import static dolphin.Competition.competitions;
import static dolphin.Member.members;

public class Foreman {



    private static Scanner scanner = new Scanner(System.in);

    //Metode til at vælge hvad formanden skal gøre.
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
                    showCompetitions();
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

    //Metode som kører i starten af programmet som downloader alle members fra en csv fil og putter dem ind i en arrayliste så vi kan bruge medlemmerne som objekter
    public static void getMembers(){
        members = FilesForeman.getMembersFromFile();
    }

    //Metode som kører i starten af programmet som downloader alle konkurrencer fra en csv fil og putter dem ind i en arrayliste så vi kan bruge konkurrencerne som objekter
    public static void getCompetetions(){
        competitions = FilesForeman.getCompetetionsFromFile();
    }


    //Metode der printer alle medlemmer på en lang overskuelig liste
    public static void callAllMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
    }

    //Metode som printer alle konkurrencerne samt de deltagere der er på holdet der eventuelt er tilmeldt konkurrencen.
    public static void showCompetitions(){
        for (int i = 0; i < competitions.size(); i++) {
           System.out.println(competitions.get(i));
        }
    }


    //Metode som opretter en ny konkurrence.
    public static void makeNewCompetition(){
        Factory factory = new Factory();
        Diciplin diciplin = Validators.getDiciplin();
        System.out.println("Is competition for senior \n yes or no?");
        boolean isSenior = Validators.validateBooleanInput();
        System.out.println("enter a place");
        String place = scanner.nextLine();
        System.out.println("Enter a start point for the competition");
        String time = scanner.nextLine();
        Competition newCompetition = factory.makeNewCompetition(diciplin, isSenior, place, time);
        competitions.add(newCompetition);
        FilesForeman.saveCompetitionInFile(newCompetition);
    }

    //Metode som kører en GUI til at oprette et nyt medlem.
    public static void makeNewMember(){
        GuiMakeNewMember gui = new GuiMakeNewMember();
    }

    //Metode som printer alle mulighederne som formanden har at vælge imellem.
    private static void callOptions(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: Make new member.");
        System.out.println("Press 2 for: See all members");
        System.out.println("Press 3 for: See all competitions");
        System.out.println("Press 4 for: Make new competition");
        System.out.println("Press 5 for: Change competetive status of a member.");
        System.out.println("Press 9 for: Quit program.");
    }

    //Metode som ændrer konkurrencestatussen for et medlem.
    private static void changeCompetetiveStatus() {
        boolean booleanChoice;
        Member currentMember = members.get(0);
        System.out.println("What is the ID of the member you want to edit status on?");

        //Finder det ønskede medlem.
        int choice = scanner.nextInt();
        for (int i = 0; i < members.size(); i++) {
            currentMember = members.get(i);
            if (choice == currentMember.getMemberID()) {
                break;
            }
        }

        //Alt afhængig af om medlemmet er konkurrencemedlem eller motionist printes der forskellige ting.
        System.out.println(currentMember);
        String isComp = currentMember.isCompetitive() == true ? "This member is currently competetive." : "This member is currently not competetive.";
        isComp += " Would you like to revert that?";
        System.out.println(isComp);
        booleanChoice = Validators.validateBooleanInput();
        if (booleanChoice == false) {
            System.out.println("Alright. I have changed nothing.");
        } else {
            if (currentMember.isCompetitive() == true) {
                currentMember.setCompetitive(false);
                currentMember.setDiciplin(null);
                FilesCashier.uploadAllMembers();
            } else {
                currentMember.setCompetitive(true);
                currentMember.setDiciplin(Validators.getDiciplin());
                FilesCashier.uploadAllMembers();
            }
        }
    }
}
