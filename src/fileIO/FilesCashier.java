package fileIO;

import dolphin.Member;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilesCashier {

    //metode der uploader alle medlemmerne.
    public static void uploadAllMembers() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("src/resources/Members.csv"));
            writer.write("ID;Name;dateOfBirth;isActive;isCompetetive;Diciplin;Restance");
            for (int i = 0; i < Member.members.size(); i++) {
                String memberToString = FilesForeman.getMemberString(Member.members.get(i));
                writer.write("\n" + memberToString);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
