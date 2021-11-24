package cashier;

import dolphin.Member;
import fileIO.Files;

import java.util.ArrayList;

public class Cashier {

    private static ArrayList<Member> members = Files.getMembersFromFile();

    //Vi giver cashier klassen en main metode, så cashier kun er autoriseret til hvad der står i tilhørende main.
    public static void main(String[] args) {
        int action = 0;
        System.out.println("Welcome Cashier");
        while (action != 0) {
            System.out.println("Pick an action: \n 1 : Show prices \n 2 : Print members in arrear \n 3 : Print estimated income \n 0 : Exit");
            switch (action) {
                case 0:
                    System.out.println("BAIIEEEE");
                case 1:
                    printPrices();
                case 2:
                    System.out.println(checkWhichMembersArrears());
                case 3:
                    System.out.println("Estimated income is: " + checkIncomeEstimate());
                default:
                    System.out.println("Invalid action");
            }
        }
    }

    private static void printPrices() {
        System.out.println("Prices: \n 0-17 years : 1000,- DKK \n 18-60 : 1600,- DKK \n 60+ : 1200,- DKK \n Passivt medlemsskab : 500,- DKK");
    }

    private static ArrayList<Member> checkWhichMembersArrears() {
        ArrayList<Member> arrearList = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isArrears()) {
                arrearList.add(members.get(i));
            }
        }
        return arrearList;
    }

    public static double checkIncomeEstimate() {
        double incomeEstimate = 0;
        for (int i = 0; i < members.size(); i++) {
            incomeEstimate += members.get(i).getSubscribtionRate();
        }
        return incomeEstimate;
    }

}
