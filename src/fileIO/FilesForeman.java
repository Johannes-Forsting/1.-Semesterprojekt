package fileIO;

import dolphin.Competition;
import dolphin.Diciplin;
import dolphin.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesForeman {



    public static void addMemberToDatabase(Member newMember) {
        String memberToString = getMemberString(newMember);
        try (FileWriter fw = new FileWriter("src/resources/Members.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(memberToString);
        } catch (IOException e) {
        }
    }


    public static void saveCompetitionInFile(Competition saveCompetition){
String convertStringToFile = convertCompetitionToString(saveCompetition);
        try(FileWriter fw = new FileWriter("src/resources/competition.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(convertStringToFile);
        } catch (IOException e) {
        }
    }

    private static String convertCompetitionToString(Competition competition){
String string = competition.getDiciplin() + ";";
string += competition.getPlace() + ";";
string += competition.getTime();
return string;

    }

    private static String getMemberString(Member member) {
        String stringToReturn = member.getMemberID() + ";";
        stringToReturn += member.getName();
        stringToReturn += ";" + getRightDateFormat(member.getDateOfBirth());
        stringToReturn += member.isActive() ? ";" + "yes" : ";" + "no";
        stringToReturn += member.isCompetitive() ? ";" + "yes" : ";" + "no";
        stringToReturn += ";" + member.getDiciplin();
        stringToReturn += ";" + "no";

        return stringToReturn;
    }

    private static String getRightDateFormat(LocalDate date){
        String[] array = date.toString().split("-");
        String stringToReturn = array[2] + "-" + array[1] + "-" + array[0];
        return stringToReturn;
    }

    public static ArrayList<Competition> readCompetitionFile() {
        ArrayList<Competition> competitions = new ArrayList<>();
        try {
            File f = new File("src/resources/competition.csv");
            Scanner scanner = new Scanner(new File("src/resources/competition.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
              String[] stringAsArray = line.split(";");
                String diciplin = stringAsArray[0];
               String place = stringAsArray[1];
             String time = stringAsArray[2];

            //   Competition competition = new Competition(diciplin,place,time);
             //  competitions.add(competition);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("not found");
        }

        return competitions;
    }

    public static ArrayList<Member> getMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            File f = new File("src/resources/Members.csv");
            Scanner scanner = new Scanner(new File("src/resources/Members.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(";");
                int id = Integer.parseInt(info[0]);
                String name = info[1];
                String date = info[2];
                boolean isActive = false;
                if (info[3].toLowerCase().equals("yes")) {
                    isActive = true;
                }
                boolean isCompetative = false;
                if (info[4].toLowerCase().equals("yes")) {
                    isCompetative = true;
                }
                Diciplin diciplin = new Diciplin(info[5]);
                boolean hasArrears = false;
                if (info[6].toLowerCase().equals("yes")) {
                    hasArrears = true;
                }
                Member currentMember = new Member(id, isCompetative, isActive, date, name, diciplin, hasArrears);
                members.add(currentMember);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return members;
    }

    public static int getNextID(){
        int idToReturn = 0;
        try {
            File f = new File("src/resources/Members.csv");
            Scanner scanner = new Scanner(new File("src/resources/Members.csv"));
            scanner.nextLine();
            String line = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }
            String[] info = line.split(";");
            idToReturn = Integer.parseInt(info[0]) + 1;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return idToReturn;
    }
}
