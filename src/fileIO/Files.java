package fileIO;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Member;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Files {
    public static ArrayList<String> getMembersResults(){
        ArrayList<String> timeResults = new ArrayList<>();
        //Arraylist<ArrayList<String>> memberResults = new ArrayList<ArrayList<String>>();
        try {
            File r = new File("src/resources/results.csv");
            Scanner scanner = new Scanner(r);
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] info = line.split(";");
                String name = info[0];
                timeResults.add(name);
                for (int i = 1; i < info.length; i++) {
                    timeResults.add(info[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return timeResults;
    }

    public static ArrayList<Member> getMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            File f = new File("src/resources/Members.csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(";");
                String name =  info[0];
                String date = info[1];
                boolean isActive = false;
                if (info[2].toLowerCase().equals("yes")){
                    isActive = true;
                }
                boolean isCompetative = false;
                if (info[3].toLowerCase().equals("yes")){
                    isCompetative = true;
                }
                Diciplin diciplin = new Diciplin(info[4]);
                boolean hasArrears = false;
                if (info[4].toLowerCase().equals("yes")){
                    hasArrears = true;
                }
                Member currentMember = new Member(isCompetative, isActive, date, name, diciplin, hasArrears);
                members.add(currentMember);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return members;
    }


    //virker, men der skal ændres lidt i toString
    public static void generateNewCompetitionFile() {
        System.out.println("give your file a name");
        System.out.println("enter done when your file is finished");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = "src/resources/";
            name += scanner.nextLine();
            name += ".csv";
            if (name.equals("src/resources/done.csv")) {
                break;
            }

            try {
                PrintWriter newFile = new PrintWriter(name);
                StringBuilder sb = new StringBuilder();
                sb.append("Diciplin");
                sb.append(",");
                sb.append("Place");
                sb.append(",");
                sb.append("Time");
                sb.append("\n");

                System.out.println("Enter a diciplin ");
                sb.append(scanner.nextLine());
                sb.append(",");
                System.out.println("Enter a place");
                sb.append(scanner.nextLine());
                sb.append(",");
                System.out.println("Now enter a start time for the competition");
                sb.append(scanner.nextLine());

                newFile.write(sb.toString());
                newFile.close();
                System.out.println("your competition is created!");

            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                e.printStackTrace();
            }
        }
    }
}




