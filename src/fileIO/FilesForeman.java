//Lavet afAsger og Johannes
package fileIO;

import dolphin.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesForeman {

    static Factory factory = new Factory();

    //Metode som uploader et enkelt medlem til members.csv filen
    public static void addMemberToDatabase(Member newMember) {
        String memberToString = getMemberString(newMember);
        try (FileWriter fw = new FileWriter("src/resources/Members.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
             out.println(memberToString);
        } catch (IOException e) {
        }
    }

    //Metode som uploader en ny konkurrence til konkurrencefilen.
    public static void saveCompetitionInFile(Competition saveCompetition){
        String convertStringToFile = convertCompetitionToString(saveCompetition);
        try(FileWriter fw = new FileWriter("src/resources/competitions/competition.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("\n" + convertStringToFile);
        } catch (IOException e) {
        }
    }

    //Metode som konvertere en konkurrence om til en string som vi kan gemme i csv-filen
    public static String convertCompetitionToString(Competition competition){
        String string = competition.getDiciplin() + ";";
        string += competition.isSenior() ? "yes" + ";" : "no" + ";";
        string += competition.getPlace() + ";";
        string += competition.getTime() + ";";
        string += competition.getCompetingTeam() == null ? "none" : competition.getCompetingTeam().getTeamName();
        return string;
    }

    //Metode som konverterer et medlem til en string som vi kan gemme i csv-filen
    public static String getMemberString(Member member) {
        String stringToReturn = member.getMemberID() + ";";
        stringToReturn += member.getName();
        stringToReturn += ";" + getRightDateFormat(member.getDateOfBirth());
        stringToReturn += member.isActive() ? ";" + "yes" : ";" + "no";
        stringToReturn += member.isCompetitive() ? ";" + "yes" : ";" + "no";
        stringToReturn += ";" + member.getDiciplin();
        stringToReturn += member.isArrears() ? ";yes" : ";no";
        return stringToReturn;
    }

    //Metode som ændrer date formatet fra DD-MM-YYYY til YYYY-MM-DD
    private static String getRightDateFormat(LocalDate date){
        String[] array = date.toString().split("-");
        String stringToReturn = array[2] + "-" + array[1] + "-" + array[0];
        return stringToReturn;
    }

    //Metode som downloader alle konkurrencer ned til en arraylist så vi kan bruge dem og kalde dem.
    public static ArrayList<Competition> getCompetetionsFromFile() {
        ArrayList<Competition> competitions = new ArrayList<>();
        try {
            File f = new File("src/resources/competitions/competition.csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(";");

                Diciplin diciplin = getRightDiciplin(info[0]);

                boolean isSenior = false;
                if (info[1].toLowerCase().equals("yes")) {
                    isSenior = true;
                }
                if(info[4].equals("none")) {
                    competitions.add(factory.makeNewCompetition(diciplin, isSenior, info[2], info[3]));
                }
                else {
                    Team tmpTeam = findTeam(info[4]);
                    competitions.add(factory.makeNewCompetition(diciplin, isSenior, info[2], info[3], tmpTeam));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return competitions;
    }

    //Metode som finder et team i filerne baseret på et teamnavn som står i konkurrencefilerne
    //Teamet bliver så oprettet og returneret
    public static Team findTeam(String teamname){
        ArrayList<Member> tmpMembers = new ArrayList<Member>();
        try {
            File f = new File("src/resources/teams/" + teamname + ".csv");
            Scanner scanner = new Scanner(f);
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] info = line.split(";");
            String teamName = info[0];
            Diciplin teamDiciplin = getRightDiciplin(info[1]);
            boolean isSenior = info[2].equals("true") ? true : false;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                info = line.split(";");
                int tmpID = Integer.parseInt(info[0]);
                for (int i = 0; i < Member.members.size(); i++) {
                    if (tmpID == Member.members.get(i).getMemberID()){
                        tmpMembers.add(Member.members.get(i));
                    }
                }
            }
            Team tmpTeam = factory.makeNewTeam(teamName, teamDiciplin, isSenior, tmpMembers);
            return tmpTeam;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return null;
    }


    //Metode som henter alle medlemmerne fra csv-filen, i starten af programmet, og propper dem ind i en arrayliste så vi kan bruge dem som objekter.
    public static ArrayList<Member> getMembersFromFile() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            File f = new File("src/resources/Members.csv");
            Scanner scanner = new Scanner(f);
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
                Diciplin diciplin = getRightDiciplin(info[5]);
                boolean hasArrears = false;
                if (info[6].toLowerCase().equals("yes")) {
                    hasArrears = true;
                }
                Member newMember = factory.makeNewMember(id, isCompetative, isActive, date, name, diciplin, false);
                members.add(newMember);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return members;
    }

    //Metode som returnere det korrekte object af diciplin baseret på en String.
    private static Diciplin getRightDiciplin(String diciplinString){
        switch (diciplinString){
            case "Crawl":
                return Diciplin.crawl;
            case "Backcrawl":
                return Diciplin.backCrawl;
            case "Butterfly":
                return Diciplin.butterFly;
            case "Breaststroke":
                return Diciplin.breastStroke;
        }
        return null;
    }

    //Metode som tjekker det sidste medlem i listen og returnere en værdi der er én højere.
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
