package program;

import dolphin.Diciplin;

import java.util.InputMismatchException;
import java.util.Scanner;
import static dolphin.Diciplin.*;

public class Validators {

    private static Scanner scanner = new Scanner(System.in);

    public static Diciplin getDiciplin(){
        int diciplin;
        System.out.println("What diciplin are you choosing?");
        System.out.println("Press 1 for: Crawl \nPress 2 for: Backcrawl\nPress 3 for: Butterfly\nPress 4 for: Breaststroke");
        diciplin = validateUserIntInput(1, 4);
        switch (diciplin){
            case 1:
                return crawl;
            case 2:
                return backCrawl;
            case 3:
                return butterFly;
            case 4:
                return breastStroke;
        }
        return null;
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
        scanner.nextLine();
        return choice;
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
}
