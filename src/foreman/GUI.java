package foreman;

import dolphin.Diciplin;
import dolphin.Factory;
import dolphin.Member;
import fileIO.FilesForeman;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    Factory factory = new Factory();

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
        String[] dicplinNames = new String[]{"None", "Crawl", "Backcrawl", "Butterfly", "Breaststroke"};
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
            if (currentIsComptetetive) {
                String var7 = this.diciplin.getSelectedItem().toString();
                byte var8 = -1;
                switch(var7.hashCode()) {
                    case -952207488:
                        if (var7.equals("Backcrawl")) {
                            var8 = 1;
                        }
                        break;
                    case 65369095:
                        if (var7.equals("Crawl")) {
                            var8 = 0;
                        }
                        break;
                    case 1172006117:
                        if (var7.equals("Breaststroke")) {
                            var8 = 3;
                        }
                        break;
                    case 2006435411:
                        if (var7.equals("Butterfly")) {
                            var8 = 2;
                        }
                }

                switch(var8) {
                    case 0:
                        currentDiciplin = Main.crawl;
                        break;
                    case 1:
                        currentDiciplin = Main.backCrawl;
                        break;
                    case 2:
                        currentDiciplin = Main.butterFly;
                        break;
                    case 3:
                        currentDiciplin = Main.breastStroke;
                }
            } else {
                currentDiciplin = null;
            }

            int nextID = FilesForeman.getNextID();

            try {
                Member newMember = this.factory.makeNewMember(nextID, currentIsComptetetive, isActive, currentDate, currentName, currentDiciplin, false);
                Foreman.members.add(newMember);
                FilesForeman.addMemberToDatabase(newMember);
                System.out.println("Member added.");
            } catch (Exception var9) {
                System.out.println("Something went wrong. Maybe you put in the wrong date format.");
            }

            this.setVisible(false);
        }

    }
}
