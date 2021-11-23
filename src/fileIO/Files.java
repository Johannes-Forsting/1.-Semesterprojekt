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


    //den kan ikke finde filen ;O
    public void getCompetition(){
        ArrayList<Competition> competitions = new ArrayList<>();


        File competition = new File("src/resources/tournament.csv");
        try {
            Scanner sc = new Scanner(competition);
            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                //System.out.println(sc.hasNextLine());
                System.out.println(nextLine);

         //  String line = sc.nextLine();
         //  String[] stringAsArray = line.split(";");
           //String disciplin = stringAsArray[0];
           //String team = stringAsArray[1];
           //String contestans = stringAsArray[2];
           //String place = stringAsArray[3];
          // double time = Integer.parseInt(stringAsArray[4]);


           //Competition showCompetetition = new Competition(disciplin,team,contestans,place,time);
         //  competitions.add(showCompetetition);
          //Collections.sort(time);
// lave om på constructor og lave get og set, måske med placement??
                // og også lave write to file og ikke kun læse fil.


            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        }


    }


