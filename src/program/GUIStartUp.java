//Lavet af Johannes
package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUIStartUp extends JFrame implements ActionListener, KeyListener {
    //Alle elementerne i guien bliver instianiseret her
    JButton button;
    JLabel username;
    JLabel password;

    JLabel pic;
    JTextField usernameField;
    JPasswordField passwordField;

    //Brugernavne og passwords til de 3 aktører
    final static String[] usernames = {"Coach", "Cashier", "Foreman"};
    final static String[] passwords = {"Coach123", "Cashier123", "Foreman123"};


    public static int logIn;


    GUIStartUp() {
        this.setTitle("Password");
        this.setDefaultCloseOperation(1);
        this.setLayout(new FlowLayout());

        //Elementerne bliver oprettet og tilgivet værdier.
        username = new JLabel("Username");
        this.username.setPreferredSize(new Dimension(100, 40));

        usernameField = new JTextField();
        this.usernameField.setPreferredSize(new Dimension(250, 40));

        password = new JLabel("Password");
        this.password.setPreferredSize(new Dimension(100, 40));

        passwordField = new JPasswordField();
        this.passwordField.setPreferredSize(new Dimension(250, 40));

        button = new JButton("Login");
        this.button.setPreferredSize(new Dimension(200, 50));
        this.button.addActionListener(this);
        this.button.addKeyListener(this);


        this.pic = new JLabel();
        ImageIcon image = new ImageIcon("src/resources/Dolphin2.jpg");
        this.pic.setIcon(image);

        this.setSize(400, 400);
        this.setVisible(true);

        //Elementerne bliver tilføjet guien i korrekt rækkefølge
        this.add(username);
        this.add(usernameField);
        this.add(password);
        this.add(passwordField);
        this.add(button);
        this.add(pic);


        ImageIcon icon = new ImageIcon("src/resources/dolphin.jpg");
        this.setIconImage(icon.getImage());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //Hvis man "tapper" ned til "login" knappen og trykker enter kører loginAttempt metoden.
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            logInAttempt();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Hvis man klikker på "login" knappen kører loginAttempt metoden
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            logInAttempt();
        }


    }


    //Metode som kører hvis "login" knappen bliver trykket
    public void logInAttempt() {
        String usernameText = usernameField.getText();
        String passwordText = passwordField.getText();

        //Hvis brugernavn passer sammen med password fjernes guien og variablen "login" får en værdi som sender os videre i porgrammet.
        if (usernameText.equals(usernames[0]) && passwordText.equals(passwords[0])) {
            logIn = 1;
            System.out.println("login succesfull.");
            this.dispose();
        } else if (usernameText.equals(usernames[1]) && passwordText.equals(passwords[1])) {
            logIn = 2;
            System.out.println("login succesfull.");

            this.dispose();
        } else if (usernameText.equals(usernames[2]) && passwordText.equals(passwords[2])) {
            logIn = 3;
            System.out.println("login succesfull.");
            this.dispose();
        } else {
            System.out.println("Username or password is incorrect. Please try again.");
        }
    }
}

