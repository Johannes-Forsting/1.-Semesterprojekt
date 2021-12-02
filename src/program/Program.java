package program;

import cashier.Cashier;
import dolphin.Coach;
import fileIO.ResultObject;
import foreman.Foreman;
import foreman.Main;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Foreman.getMembers();
        ResultObject.createAllResultObjects();

        //Kalder GUI til login
        GUIStartUp guiStartUp = new GUIStartUp();


        //While loop for ikke at forsætte før vi er logget ind.
        while (true){
            if (GUIStartUp.logIn != 0){
                break;
            }
            System.out.printf("");
        }

        //Switch som kører henholdsvis Coach-metode, Cashier-metode eller Foreman-metode alt afhængig af hvad man loggede ind som.
        switch (GUIStartUp.logIn){
            case 1:
                System.out.println("in coach");
                Coach.coachOptions();
                break;
            case 2:
                System.out.println("in cashier");
                Cashier.cashierOptions();
                break;
            case 3:
                System.out.println("in foreman");
                Main.foremanOptions();
                break;
        }
    }
}
