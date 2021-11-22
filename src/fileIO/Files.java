package fileIO;

import dolphin.Member;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
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
                int age = Integer.parseInt(info[1]);
                boolean isCompetative = false;
                if (info[2].toLowerCase().equals("yes")){
                    isCompetative = true;
                }
                boolean isActive = false;
                if (info[3].toLowerCase().equals("yes")){
                    isActive = true;
                }
                String date = info[4];
                Member currentMember = new Member(isCompetative, isActive, date, name, true);
                members.add(currentMember);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }

        return members;
    }


    //virker ikke
    public void showCompetition(){


        try {
            File competition = new File("src/resources/test.csv");
            Scanner sc = new Scanner(competition);
            sc.nextLine();
            while (sc.hasNextLine()) {
                System.out.println(sc.hasNextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();

        }

        }


    }


