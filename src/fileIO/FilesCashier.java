package fileIO;

import foreman.Foreman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FilesCashier {

    public static void UploadAllMembers(){
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter("src/resources/Members.csv"));
                writer.write("ID;Name;dateOfBirth;isActive;isCompetetive;Diciplin;Restance");
                for (int i = 0; i < Foreman.members.size(); i++) {
                    String memberToString = FilesForeman.getMemberString(Foreman.members.get(i));
                    writer.write("\n" + memberToString);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public static void addToFile(ArrayList<String> haikus) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("Haikus.csv"));
            writer.write(haikus.get(0));
            for (int i = 1; i < haikus.size(); i++) {
                writer.write("\n" + haikus.get(i));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
