import javax.swing.*;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.math.BigInteger;
import java.util.*;

public class Updation{

    JFrame Fname;
    JFrame number;
    JFrame i;

    Updation() {
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


        if (file.isFile()) {
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
            String name = JOptionPane.showInputDialog(i, "Enter name to update: ");
            boolean found = false;
            li = al.listIterator();
            while (li.hasNext()) {
                Phone p = (Phone) li.next();
                if (p.name.equals(name))
                {
                    String number = JOptionPane.showInputDialog(i, "Enter number to update: ");
                    if(number.matches("[7-9][0-9]{9}")){

                        li.set(new Phone(name, number));
                    found = true;
                }
            }}
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
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JOptionPane.showMessageDialog(Fname, "Contact Updated Successfully");

            } else {
                JOptionPane.showMessageDialog(Fname, "Invalid", "Invalid", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {

        new Updation();
    }
}
