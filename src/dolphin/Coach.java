package dolphin;

import fileIO.FilesCoach;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach {
public static ArrayList<String> bestResults = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public void showResults() {
        for (int i = 0; i < bestResults.size(); i++) {
            System.out.println(bestResults.get(i));
        }
    }
        public void getResults(){
            bestResults = FilesCoach.getButterflyResults();
            bestResults = FilesCoach.getCrawlResults();
        }



    public void makeNewTeam(){
Factory factoryPattern = new Factory();
        System.out.println("Enter the name of the team");
        String teamName = scanner.nextLine();

        Team newTeam = factoryPattern.makeNewTeam(teamName);
       // bestResults.add(newTeam);
        FilesCoach.getBreastStrokeResults();

    }
}
