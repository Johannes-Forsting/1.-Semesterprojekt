package foreman;

import java.util.InputMismatchException;
import java.util.Scanner;

import fileIO.Files;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static Files file = new Files();
    public static void main(String[] args) {
        choices();
    }


    private static void choices(){
        boolean whileCondition = true;
        while (whileCondition){
            int choice = newChoice();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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


    private static int newChoice(){
        int choice;
        while(true){
            callOptions();
            try{
                choice = scanner.nextInt();
                if (choice > 10 || choice < 1){
                    throw new InputMismatchException();
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please only write anything between 1 and 10");
            }
        }
        return choice;
    }

    private static void callOptions(){
        System.out.println("============CHOOSE AN OPTION============");
        System.out.println("Press 1 for: ");
        System.out.println("Press 2 for: ");
        System.out.println("Press 3 for: ");
        System.out.println("Press 4 for: ");
        System.out.println("Press 5 for: ");
        System.out.println("Press 6 for: ");
        System.out.println("Press 7 for: ");
        System.out.println("Press 8 for: ");
        System.out.println("Press 9 for: ");
        System.out.println("Press 10 for: Quit Program");
    }
}
