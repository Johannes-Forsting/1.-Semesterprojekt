package foreman;

import dolphin.Diciplin;
import dolphin.Factory;
import dolphin.Member;
import fileIO.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Foreman {
    public static ArrayList<Member> members = Files.getMembersFromFile();
    private static Scanner scanner = new Scanner(System.in);



    public static void callAllMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
    }

    public static void makeNewMember(){
        Factory factory = new Factory();
        System.out.println("What is the name of the new member?");
        String name = scanner.nextLine();

        System.out.println("What is the date of birth of the new member? (DD-MM-YYY");
        String dateOfBirth = getDateOfBirth();

        boolean isActive = true;

        System.out.println("Is this person gonna be competetive? \"yes/no\"");
        boolean isCompetetive = validateBooleanInput();

        System.out.println("What diciplin is this person gonna be?");
        String diciplin = getDiciplin();

        Member newMember = factory.makeNewMember(isCompetetive, isActive, dateOfBirth, name, new Diciplin(diciplin), false);
        members.add(newMember);
        Files.addMemberToDatabase(newMember);
    }

    private static String getDiciplin(){
        String diciplin = scanner.nextLine();
        return diciplin;
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
