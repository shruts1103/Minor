import javax.swing.*;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
//import java.math.BigInteger;
import java.util.*;


public class Insertion {

    JFrame Fname;
    JFrame number;
    JFrame i;

    Insertion(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Fname = new JFrame();
        number = new JFrame();
        i = new JFrame();
        ArrayList<Phone> al = new ArrayList<Phone>();
        File file = new File("phonedirectory.txt");


        try {
            FileInputStream fi = new FileInputStream(new File("phonedirectory.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Object pr1 = (Object) oi.readObject();
            al = (ArrayList<Phone>) pr1;
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        String it = JOptionPane.showInputDialog(i,"Enter how many persons details you want to add?");

       int j = Integer.parseInt(it);
        for(int i=0;i<j;i++) {
            String name = JOptionPane.showInputDialog(Fname,"Enter Name");
            String num = JOptionPane.showInputDialog(number,"Enter Phone Number");
            if(num.matches("[7-9][0-9]{9}")){
                al.add(new Phone(name,num));
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Contact Saved Successfully");
            }
            else{
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Invalid Number","Invalid",JOptionPane.WARNING_MESSAGE);
            }
        }
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

    }

    public static void main(String[] args) {
        new Insertion();
    }
}

