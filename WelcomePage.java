import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.System.exit;

public class WelcomePage extends JFrame
{
    Frame fObj;
    JFrame frame = new JFrame();
    JButton Insert, Delete, Search, Update, Display, Emergency,Exit;
    JLabel l1;
    Font f1;
    Font f2;

    WelcomePage() {
        fObj = new Frame ("Digital Telephone Diary");
        Insert = new JButton("Insert");
        Delete = new JButton("Delete");
        Search = new JButton("Search");
        Update = new JButton("Update");
        Display = new JButton("Display");
        Emergency = new JButton("Emergency Contacts");
        Exit = new JButton("EXIT");
        l1 = new JLabel("Telephone Diary");
        f1 = new Font("Algerian",Font.BOLD,40);
        f2 = new Font("Monospaced",Font.ITALIC,15);
        l1.setFont(f1);
        fObj.add(l1);
        Insert.setFont(f2);
        Delete.setFont(f2);
        Search.setFont(f2);
        Update.setFont(f2);
        Display.setFont(f2);
        Emergency.setFont(f2);
        Exit.setFont(f2);
        fObj.add(Insert);
        fObj.add(Delete);
        fObj.add(Search);
        fObj.add(Update);
        fObj.add(Display);
        fObj.add(Emergency);
        fObj.add(Exit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fObj.setLayout(new FlowLayout(FlowLayout.CENTER,1920,60));
        fObj.setSize(1920,1080);
        frame.setLayout(null);
        fObj.setVisible(true);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });
        Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insertion insertion = new Insertion();
            }
        });
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deletion deletion = new Deletion();
            }
        });
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Updation updation = new Updation();
            }
        });
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Searching searching = new Searching();
            }
        });
        Display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Displaying displaying = new Displaying();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Emergency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Emergency_Contact emergency_contact = new Emergency_Contact();
            }
        });
    }



    public static void main (String args[])
    {
        new Menu();
    }

}
