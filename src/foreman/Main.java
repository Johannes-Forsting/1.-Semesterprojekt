package foreman;

import java.util.InputMismatchException;
import java.util.Scanner;

import dolphin.Diciplin;
import fileIO.FilesForeman;

public class Main {
    static Scanner scanner = new Scanner(System.in);



    public static Diciplin backCrawl = new Diciplin("Backcrawl");
    public static Diciplin crawl = new Diciplin("Crawl");
    public static Diciplin butterFly = new Diciplin("Butterfly");
    public static Diciplin breastStroke = new Diciplin("Breaststroke");


    public static void main(String[] args) {

        Foreman.getMembers();
        choices();
    }


    private static void choices(){
        boolean whileCondition = true;
        while (whileCondition){
            callOptions();
            int choice = validateUserIntInput(1, 10);
            switch (choice){
                case 1:
                    Foreman.makeNewMember();
                    break;
                case 2:
                    Foreman.callAllMembers();
                    break;
                case 3:
                    break;
                case 4:
                 Foreman.showCompetition();
                    break;
                case 5:
                    Foreman.makeNewCompetition();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    whileCondition = false;
                    break;
            }
        }
    }


    public static int validateUserIntInput(int min, int max){
        int choice;
        while(true){
            try{
                choice = scanner.nextInt();
                if (choice > max || choice < min){
                    throw new InputMismatchException();
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please only write anything between " + min +" and " + max);
            }
        }
        return choice;
    }

    private static void callOptions(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: Make new member.");
        System.out.println("Press 2 for: See all members");
        System.out.println("Press 3 for: ");
        System.out.println("Press 4 for: See all competitions");
        System.out.println("Press 5 for: Make new competition");
        System.out.println("Press 6 for: ");
        System.out.println("Press 7 for: ");
        System.out.println("Press 8 for: ");
        System.out.println("Press 9 for: ");
        System.out.println("Press 10 for: Quit Program");
    }
}
