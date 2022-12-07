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

public class Displaying extends JFrame {

    JFrame Fname;
    JFrame number;
    JFrame i;

    Displaying() throws IOException, ClassNotFoundException {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"All Contacts", TitledBorder.CENTER,TitledBorder.TOP));
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Fname = new JFrame();
        number = new JFrame();
        i = new JFrame();
        ArrayList<Phone> al = new ArrayList<Phone>();
        File file = new File("phonedirectory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al= (ArrayList<Phone>)ois.readObject();
            ois.close();
            System.out.println("-----------------------------------");
            System.out.println("First Name  Last Name ");
            System.out.println("---------- ----------");


            Collections.sort(al,
                    (e1, e2) -> e1.name.compareTo(e2.name));

            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(al);
            oos.close();

            li= al.listIterator();
            while(li.hasNext()){
                System.out.println(li.next());
            }

            System.out.println("-----------------------------------");
        }
        else{
            System.out.println("File not exits!!");
        }


        if(file.isFile()){
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                al= (ArrayList<Phone>)ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String [][] values = new String[al.size()][2];
            for (int j = 0; j < al.size(); j++) {
                String str = String.valueOf(al.get(j));
                String[] arr = str.split("\\s+");
                values[j][0]=arr[0];
                values[j][1]=arr[1];
            }
        String[] col = {"Name","Phone"};
            JTable table = new JTable(values,col);
            table.setShowHorizontalLines(true);
            panel.add(new JScrollPane(table));
            frame.add(panel);
            frame.setSize(700,700);
            frame.setVisible(true);

               }

        else{
            JOptionPane.showMessageDialog(Fname,"File Not Exists!!","File Not Found",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        new Displaying();
    }
}

