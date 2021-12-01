package foreman;

import dolphin.*;
import fileIO.FilesCoach;
import fileIO.FilesForeman;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static dolphin.Coach.chooseDiciplin;
import static dolphin.Coach.getTop5Members;
import static dolphin.Team.teams;

public class Foreman {
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Competition> competitions = new ArrayList<Competition>();
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Team>



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
        System.out.println("Enter a diciplin for the competition");
       String diciplin = scanner.nextLine();
        System.out.println("enter a place");
        String place = scanner.nextLine();
        System.out.println("Enter a start point for the competition");
        String time = scanner.nextLine();
        System.out.println("select a team to add");


Competition newCompetition = factory.makeNewCompetition(diciplin,place,time,competingTeams);
competitions.add(newCompetition);
FilesForeman.saveCompetitionInFile(newCompetition);

    }

    public static void makeNewMember(){
        GUI gui = new GUI();
    }





    private static Diciplin getDiciplin(){
        int diciplin;
        System.out.println("What diciplin is this person gonna be?");
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


    private static boolean validateBooleanInput(){
        boolean isCompetetive;
        while(true){
            String choice = scanner.nextLine();
            if(choice.toLowerCase().equals("yes")){
                isCompetetive = true;
                break;
            }
            else if (choice.toLowerCase().equals("no")){
                isCompetetive = false;
                break;
            }
            else {
                System.out.println("I dont understand. Is this person gonna be competetive? \"yes/no\"");
            }
        }
        return isCompetetive;
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
