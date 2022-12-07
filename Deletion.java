import javax.swing.*;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.math.BigInteger;
import java.util.*;

public class Deletion {

    JFrame Fname;
    JFrame number;
    JFrame i;

    Deletion(){
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
        if(file.isFile()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                al = (ArrayList<Phone>) ois.readObject();
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
            String name = JOptionPane.showInputDialog(Fname, "Enter the name to delete:");
            boolean found = false;
            li = al.listIterator();
            while (li.hasNext()) {
                Phone p = (Phone) li.next();
                if (p.name.equals(name))
                    li.remove();
                found = false;
            }
            if (found) {
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(file));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    oos.writeObject(al);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    oos.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Contact Deleted Successfully");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            else {
                System.out.println("Not Found");
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Record Not Found", "Invalid", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public static void main(String[] args) {
        new Deletion();
    }
}
