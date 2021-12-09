//Lavet af Johannes
package program;

import cashier.Cashier;

import coach.Coach;
import fileIO.ResultObject;
import foreman.Foreman;

public class Program {
    public static void main(String[] args) {
        //De aktuelle medlemmer og resultater bliver loadet ned fra csv-filerne til arraylister som det første når programmet starter.
        Foreman.getMembers();
        ResultObject.createAllResultObjects();
        Foreman.getCompetetions();

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
                Coach.coachOptions();
                break;
            case 2:
                Cashier.cashierOptions();
                break;
            case 3:
                Foreman.foremanOptions();
                break;
        }
    }
}
