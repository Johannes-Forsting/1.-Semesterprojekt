package cashier;

import dolphin.Member;
import fileIO.FilesCashier;
import fileIO.FilesCoach;
import fileIO.FilesForeman;
import foreman.Foreman;
import foreman.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {


    private static Scanner scanner = new Scanner(System.in);

    public static void cashierOptions(){
        System.out.println("Welcome Cashier");
        boolean whileCondition = true;
        while (whileCondition == true) {
            System.out.println("Pick an action: \n0 : Exit. \n1 : Show prices. \n2 : Print estimated income.\n3 : See all members.");
            System.out.println("4 : Print members in arrears. \n5: Set member out of arrears. \n6: Set all members in arrears.");
            System.out.println("7: Set member active/inactive.");
            int action = Main.validateUserIntInput(0, 7);
            switch (action) {
                case 0:
                    System.out.println("BAIIEEEE");
                    System.exit(0);
                    break;
                case 1:
                    printPrices();
                    break;
                case 2:
                    System.out.println("Estimated income is: " + checkIncomeEstimate() + " DKK,-\n\n");
                    break;
                case 3:
                    Foreman.callAllMembers();
                    break;
                case 4:
                    checkWhichMembersArrears();
                    break;
                case 5:
                    setMemberOutOfArrears();
                    break;
                case 6:
                    setAllMembersInArrears();
                    break;
                case 7:
                    setMemberActiveInactive();
                    break;
            }
        }
    }




    private static void printPrices() {
        System.out.println("Prices: \n 0-17 years old: \t\t1000,- DKK \n 18-60 years old: \t\t1600,- DKK \n 60+ years old: \t\t1200,- DKK \n Passive membership : \t500,- DKK");
        System.out.println("\n\n");
    }

    private static void checkWhichMembersArrears() {
        for (int i = 0; i < Foreman.members.size(); i++) {
            if (Foreman.members.get(i).isArrears()) {
                System.out.println(Foreman.members.get(i).toString());
            }
        }
    }

    public static double checkIncomeEstimate() {
        double incomeEstimate = 0;
        for (int i = 0; i < Foreman.members.size(); i++) {
            incomeEstimate += Foreman.members.get(i).getSubscribtionRate();
        }
        return incomeEstimate;
    }


    public static void setMemberOutOfArrears(){
        System.out.println("What is the ID of the paid member?");
        int choice = scanner.nextInt();
        for (int i = 0; i < Foreman.members.size(); i++) {
            Member currentMember = Foreman.members.get(i);
            if(choice == currentMember.getMemberID()){
                if (currentMember.isArrears() == false){
                    System.out.println("This member does not have arrears.");
                    break;
                }
                else{
                    currentMember.setArrears(false);
                    FilesCashier.UploadAllMembers();
                    break;
                }
            }
        }
    }

    public static void setAllMembersInArrears(){
        for (int i = 0; i < Foreman.members.size(); i++) {
            Foreman.members.get(i).setArrears(true);
        }
        FilesCashier.UploadAllMembers();
    }

    public static void setMemberActiveInactive(){
        System.out.println("What is the ID of the member?");
        int choice = scanner.nextInt();
        Member currentMember = Foreman.members.get(0);
        for (int i = 0; i < Foreman.members.size(); i++) {
            currentMember = Foreman.members.get(i);
            if (currentMember.getMemberID() == choice) {
                break;
            }
        }
        String toPrint = "This member:\n" + currentMember.toString() + "\nis currently: ";
        toPrint += currentMember.isActive() ? "active." : "inactive.";
        toPrint += " Would you like to revert that? (1: for \"yes\" 2: for \"no\")";
        System.out.println(toPrint);

        choice = Main.validateUserIntInput(1, 2);
        if (choice == 1){
            boolean boolToSet = currentMember.isActive() ? false : true;
            System.out.println("It has now been reverted.");
            currentMember.setActive(boolToSet);
            FilesCashier.UploadAllMembers();
        }
        else if (choice == 2){
            System.out.println("Allright i have changed nothing.");
        }
        else{
            System.out.println("I dont understand.");
        }
    }






}
