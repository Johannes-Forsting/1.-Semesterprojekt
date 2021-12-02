package foreman;

import dolphin.*;
import fileIO.FilesCoach;
import fileIO.FilesForeman;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static dolphin.Team.teams;

public class Foreman {
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Competition> competitions = new ArrayList<Competition>();
    private static Scanner scanner = new Scanner(System.in);



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


    public static void getMembers(){
        members = FilesForeman.getMembersFromFile();
    }



    public static void makeNewCompetition(){
        Factory factory = new Factory();
        Diciplin diciplin = getDiciplin();
        System.out.println("Is competition for senior \n yes or no?");
        boolean isSenior = validateBooleanInput();
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





    private static Diciplin getDiciplin(){
        int diciplin;
        System.out.println("What diciplin is the team gonna be?");
        System.out.println("Press 1 for: Crawl \nPress 2 for: Backcrawl\nPress 3 for: Butterfly\nPress 4 for: Breaststroke");
        diciplin = Main.validateUserIntInput(1, 4);
        switch (diciplin){
            case 1:
                return Main.crawl;
            case 2:
                return Main.backCrawl;
            case 3:
                return Main.butterFly;
            case 4:
                return Main.breastStroke;
        }
        return null;
    }



    public static boolean validateBooleanInput(){
        boolean isTrue;
        while(true){
            String choice = scanner.nextLine();
            if(choice.toLowerCase().equals("yes") || choice.toLowerCase().equals("y")){
                isTrue = true;
                break;
            }
            else if (choice.toLowerCase().equals("no") || choice.toLowerCase().equals("n")){
                isTrue = false;
                break;
            }
            else {
                System.out.println("Invalid option, please type - \"yes/no\"");
            }
        }
        return isTrue;
    }

    private static String getDateOfBirth(){
        String date;
        while (true){
            date = scanner.nextLine();
            try {
                String[] thisDate = date.split("-");
                int year = Integer.parseInt(thisDate[2]);
                int month = Integer.parseInt(thisDate[1]);
                int day = Integer.parseInt(thisDate[0]);
                LocalDate tester = LocalDate.of(year, month, day);
                break;
            }
            catch (Exception e){
                System.out.println("Not a valid input. Write in format \"DD-MM-YYYY\"");
            }
        }
        return date;
    }






}
