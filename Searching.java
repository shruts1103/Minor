import javax.swing.*;
import java.io.File;
import java.io.*;
//import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.math.BigInteger;
import java.util.*;

public class Searching {

    JFrame Fname;
    JFrame number;
    JFrame i;

    Searching(){
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
            boolean found = false;
            String name = JOptionPane.showInputDialog(Fname,"Enter Name");

            li= al.listIterator();
            while(li.hasNext()){
                Phone p = (Phone)li.next();
                if(p.name.equals(name)){
                    String str = String.valueOf(p);
                    String[] arr = str.split("\\s+");
                    System.out.println(arr[0] + arr[1]);
                    found=true;

                    JOptionPane.showMessageDialog(Fname,"Name: "+arr[0]+ "\nPhone No.: "+arr[1]);
                }
            }
            if(!found)
            JOptionPane.showMessageDialog(Fname,"No such record exists!!","Not Found",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(Fname,"File Not Exists!!","File Not Found",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Searching();
    }
}

