package cashier;

import dolphin.Member;
import fileIO.FilesCoach;
import fileIO.FilesForeman;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {

    private static ArrayList<Member> members = FilesForeman.getMembersFromFile();
    private static Scanner scanner = new Scanner(System.in);

    //Vi giver cashier klassen en main metode, så cashier kun er autoriseret til hvad der står i tilhørende main.
    public static void main(String[] args) {

        System.out.println("Welcome Cashier");
        int action = 1;
        while (action != 0) {
            System.out.println("Pick an action: \n0 : Exit \n1 : Show prices \n2 : Print members in arrear \n3 : Print estimated income");
            action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("BAIIEEEE");
                    break;
                case 1:
                    printPrices();
                    break;
                case 2:
                    checkWhichMembersArrears();
                    break;
                case 3:
                    System.out.println("Estimated income is: " + checkIncomeEstimate());
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }

    private static void printPrices() {
        System.out.println("Prices: \n 0-17 years old: \t\t1000,- DKK \n 18-60 years old: \t\t1600,- DKK \n 60+ years old: \t\t1200,- DKK \n Passive membership : \t500,- DKK");
        System.out.println("\n\n");
    }

    private static void checkWhichMembersArrears() {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isArrears()) {
                System.out.println(members.get(i).toString());
            }
        }
    }

    public static double checkIncomeEstimate() {
        double incomeEstimate = 0;
        for (int i = 0; i < members.size(); i++) {
            incomeEstimate += members.get(i).getSubscribtionRate();
        }
        return incomeEstimate;
    }






}
