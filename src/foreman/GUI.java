package foreman;

import dolphin.Diciplin;
import dolphin.Factory;
import dolphin.Member;
import fileIO.FilesForeman;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.util.NoSuchElementException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
    JButton button;
    JLabel nameLabel;
    JLabel dateLabel;
    JLabel isCompLabel;
    JLabel diciplinLabel;
    JLabel pic;
    JTextField name;
    JTextField dateOfBirth;
    JTextField isActive;
    JComboBox diciplin;
    JComboBox isCompetetive;
    Factory factory = new Factory(); //facotry

    static String[] dicplinNames = {"None", "Crawl", "Backcrawl", "Butterfly", "Breaststroke"};

    GUI() {
        this.setTitle("Test");
        this.setDefaultCloseOperation(1);
        this.setLayout(new FlowLayout());

        this.nameLabel = new JLabel("Name");
        this.dateLabel = new JLabel("Date (DD-MM-YYYY)");
        this.isCompLabel = new JLabel("Competetive? (\"yes\" / \"no\")");
        this.diciplinLabel = new JLabel("Diciplin? (If not competetive, leave blank.)");

        this.name = new JTextField();
        this.name.setPreferredSize(new Dimension(250, 40));

        this.dateOfBirth = new JTextField();
        this.dateOfBirth.setPreferredSize(new Dimension(250, 40));

        this.isCompetetive = new JComboBox(new String[]{"Yes", "No"});
        this.isCompetetive.setPreferredSize(new Dimension(250, 40));


        this.diciplin = new JComboBox(dicplinNames);
        this.diciplin.setPreferredSize(new Dimension(250, 40));

        this.button = new JButton("Click to add member");
        this.button.addActionListener(this);

        this.pic = new JLabel();
        ImageIcon image = new ImageIcon("src/resources/Dolphin2.jpg");
        this.pic.setIcon(image);

        this.setSize(300, 520);
        this.setVisible(true);

        this.add(this.nameLabel);
        this.add(this.name);
        this.add(this.dateLabel);
        this.add(this.dateOfBirth);
        this.add(this.isCompLabel);
        this.add(this.isCompetetive);
        this.add(this.diciplinLabel);
        this.add(this.diciplin);
        this.add(this.button);
        this.add(this.pic);

        ImageIcon icon = new ImageIcon("src/resources/dolphin.jpg");
        this.setIconImage(icon.getImage());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            String currentName = this.name.getText();
            String currentDate = this.dateOfBirth.getText();
            boolean isActive = true;
            boolean currentIsComptetetive;
            if (this.isCompetetive.getSelectedItem().toString().equals("Yes")) {
                currentIsComptetetive = true;
            } else {
                currentIsComptetetive = false;
            }

            Diciplin currentDiciplin = null;
            if (currentIsComptetetive == true) {
                String thisDiciplin = this.diciplin.getSelectedItem().toString();
                switch(thisDiciplin) {
                    case "crawl":
                        currentDiciplin = Main.crawl;
                        break;
                    case "Backcrawl":
                        currentDiciplin = Main.backCrawl;
                        break;
                    case "Butterfly":
                        currentDiciplin = Main.butterFly;
                        break;
                    case "Breaststroke":
                        currentDiciplin = Main.breastStroke;
                }
            } else {
                currentDiciplin = null;
            }

            int nextID = FilesForeman.getNextID();

            try {
                if (currentIsComptetetive == true && currentDiciplin == null){
                    throw new NoSuchElementException();
                }
                Member newMember = this.factory.makeNewMember(nextID, currentIsComptetetive, isActive, currentDate, currentName, currentDiciplin, false);
                Foreman.members.add(newMember);
                FilesForeman.addMemberToDatabase(newMember);
                System.out.println("Member added.");
            } catch (DateTimeException exception1) {
                System.out.println("Something went wrong. Maybe you put in the wrong date format. (DD-MM-YYYY).");
            }
            catch (NoSuchElementException exception2){
                System.out.println("You have to have a diciplin to be a competetive svimmer.");
            }
            this.setVisible(false);
        }
    }
}
