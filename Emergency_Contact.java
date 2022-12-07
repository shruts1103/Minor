import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import java.awt.*;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.math.BigInteger;
import java.util.*;

public class Emergency_Contact extends JFrame {



    Emergency_Contact(){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"DEHRADUN EMERGENCY CONTACTS", TitledBorder.CENTER,TitledBorder.TOP));

            String[][] values = {
                    {"Women's Helpline","1091"},
                    {"Fire Brigade","101"},
                    {"Emergency Medical","102"},
                    {"ity Control Room Dehradun","01334-265876"},
                    {"Child helpline","1098"},
            };
            String[] col = {"Name","Phone"};
            JTable table = new JTable(values,col);
            table.setShowHorizontalLines(true);
            panel.add(new JScrollPane(table));
            frame.add(panel);
            frame.setSize(700,700);
            frame.setVisible(true);

    }

    public static void main(String[] args) {

        new Emergency_Contact();
    }
}

