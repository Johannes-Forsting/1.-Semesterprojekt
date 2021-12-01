package foreman;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Factory;
import dolphin.Member;
import fileIO.FilesCoach;
import fileIO.FilesForeman;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Enter a diciplin for the competition");
        String diciplin = scanner.nextLine();
        System.out.println("enter a place");
        String place = scanner.nextLine();
        System.out.println("Enter a start point for the competition");
        String time = scanner.nextLine();

        Competition newCompetition = factory.makeNewCompetition(diciplin,place,time);
        competitions.add(newCompetition);
        FilesForeman.saveCompetitionInFile(newCompetition);

    }

    public static void makeNewMember(){
        GUI gui = new GUI();
    }



}
