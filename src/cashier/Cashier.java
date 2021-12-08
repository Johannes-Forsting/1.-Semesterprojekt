package cashier;

import dolphin.Member;
import fileIO.FilesCashier;
import foreman.Foreman;
import program.Validators;

import java.util.Scanner;

public class Cashier {


    private static Scanner scanner = new Scanner(System.in);

    public static void cashierOptions(){
        System.out.println("Welcome Cashier");
        while (true) {
            callOptions();
            int action = Validators.validateUserIntInput(1, 10);
            switch (action) {
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
                case 9:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void callOptions(){
        System.out.println("Pick an action:" +
                "\n1: Show prices." +
                "\n2: Print estimated income." +
                "\n3: See all members." +
                "\n4: Print members in arrears." +
                "\n5: Set member out of arrears." +
                "\n6: Set all members in arrears." +
                "\n7: Set member active/inactive." +
                "\n9: Exit.");
    }




    private static void printPrices() {
        System.out.println("Prices: \n 0-17 years old: \t\t1000,- DKK \n 18-60 years old: \t\t1600,- DKK \n 60+ years old: \t\t1200,- DKK \n Passive membership : \t500,- DKK");
        System.out.println("\n\n");
    }

    //Tjekker hvilke medlemmer der er i restance ved at køre i gennem arraylisten med medlemmer.
    private static void checkWhichMembersArrears() {
        for (int i = 0; i < Member.members.size(); i++) {
            if (Member.members.get(i).isArrears()) {
                System.out.println(Member.members.get(i).toString());
            }
        }
    }

//Tjekker den forventede indkomst ved at køre igennem arraylisten med medlemmer.
    public static double checkIncomeEstimate() {
        double incomeEstimate = 0;
        for (int i = 0; i < Member.members.size(); i++) {
            incomeEstimate += Member.members.get(i).getSubscribtionRate();
        }
        return incomeEstimate;
    }


//Filen og arraylisten med medlemmer bliver brugt til at tjekke og sætte medlemmer ud af restance
    public static void setMemberOutOfArrears(){
        System.out.println("What is the ID of the paid member?");
        int choice = scanner.nextInt();
        for (int i = 0; i < Member.members.size(); i++) {
            Member currentMember = Member.members.get(i);
            if(choice == currentMember.getMemberID()){
                if (currentMember.isArrears() == false){
                    System.out.println("This member does not have arrears.");
                    break;
                }
                else{
                    currentMember.setArrears(false);
                    FilesCashier.uploadAllMembers();
                    break;
                }
            }
        }
    }

    //Samme fremgangsmåde med metoden ovenover, men bare med at sætter folk i restance.
    public static void setAllMembersInArrears(){
        for (int i = 0; i < Member.members.size(); i++) {
            Member.members.get(i).setArrears(true);
        }
        FilesCashier.uploadAllMembers();
    }

    //En metoder der bliver brugt til at sætte medlemmer inaktive. Her bliver Arraylisten med members og filen indlæst og kasseren får muligheden for at ændre om de er aktive eller ej.
    public static void setMemberActiveInactive(){
        System.out.println("What is the ID of the member?");
        int choice = scanner.nextInt();
        Member currentMember = Member.members.get(0);
        for (int i = 0; i < Member.members.size(); i++) {
            currentMember = Member.members.get(i);
            if (currentMember.getMemberID() == choice) {
                break;
            }
        }
        String toPrint = "This member:\n" + currentMember.toString() + "\nis currently: ";
        toPrint += currentMember.isActive() ? "active." : "inactive.";
        toPrint += " Would you like to revert that? (1: for \"yes\" 2: for \"no\")";
        System.out.println(toPrint);

        choice = Validators.validateUserIntInput(1, 2);
        if (choice == 1){
            boolean boolToSet = currentMember.isActive() ? false : true;
            System.out.println("It has now been reverted.");
            currentMember.setActive(boolToSet);
            FilesCashier.uploadAllMembers();
        }
        else if (choice == 2){
            System.out.println("Allright i have changed nothing.");
        }
        else{
            System.out.println("I dont understand.");
        }
    }
}
