package foreman;

import dolphin.Member;
import fileIO.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Foreman {
    private static ArrayList<Member> members;

    public Foreman(){
        this.members = Files.getMembersFromFile();
    }


    public void callAllMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
    }
}
