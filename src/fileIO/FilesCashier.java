package fileIO;

import foreman.Foreman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FilesCashier {

    public static void uploadAllMembers() {
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
}
