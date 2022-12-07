import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.math.BigInteger;
import java.util.*;
class Phone implements Serializable{
    //private static final long serialVersionUID = -164085539370511047L;
    String name;
    String number;

    Phone(String name, String number){
        this.name = name;
        this.number = number;
    }
    public String toString(){
        return name+" "+number;
    }
}

public class demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int choice=-1;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        ArrayList<Phone> al = new ArrayList<Phone>();
        File file = new File("phonedirectory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al= (ArrayList<Phone>)ois.readObject();
            ois.close();
        }
        do{
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("0.EXIT");
            System.out.print("Enter your choice:");
            //System.out.println("UPDATE");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter how many persons details you want to add?");
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++) {
                        System.out.println("Enter name of the person:");
                        String name = sc1.nextLine();
                        System.out.println("Enter contact details:");
                        String number = sc1.nextLine();
                        if(number.matches("[7-9][0-9]{9}")){
                            al.add(new Phone(name,number));
                        }
                        else{
                            System.out.println("Invalid number");
                        }
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;
                case 2:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al= (ArrayList<Phone>)ois.readObject();
                        ois.close();
                        System.out.println("-----------------------------------");
                        li= al.listIterator();
                        while(li.hasNext()){
                            System.out.println(li.next());
                        }
                        System.out.println("-----------------------------------");
                    }
                    else{
                        System.out.println("File not exits!!");
                    }
                    break;
                case 3:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al= (ArrayList<Phone>)ois.readObject();
                        ois.close();
                        boolean found = false;
                        System.out.print("Enter the name to search:");
                        String name = sc1.nextLine();
                        System.out.println("-----------------------------------");
                        li= al.listIterator();
                        while(li.hasNext()){
                            Phone p = (Phone)li.next();
                            if(p.name.equals(name)){
                                System.out.println(p);
                                found=true;
                            }
                        }
                        if(!found)
                            System.out.println("No such record exists!!");
                        System.out.println("-----------------------------------");
                    }else{
                        System.out.println("File not exists!!");
                    }
                    break;

                case 4:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al= (ArrayList<Phone>)ois.readObject();
                        ois.close();
                        System.out.print("Enter the name to delete:");
                        String name = sc1.nextLine();
                        boolean found = false;
                        System.out.println("--------------------------------------");
                        li= al.listIterator();
                        while(li.hasNext()){
                            Phone p = (Phone)li.next();
                            if(p.name.equals(name))
                                li.remove();
                            found=true;
                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Record deleted successfully!!");
                            System.out.println("-----------------------------------");
                        }

                    }else{
                        System.out.println("Record not found!!");
                    }

                    break;
                case 5:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al= (ArrayList<Phone>)ois.readObject();
                        ois.close();
                        System.out.print("Enter the name to update:");
                        String name = sc1.nextLine();
                        boolean found = false;
                        System.out.println("-----------------------------------");
                        li= al.listIterator();
                        while(li.hasNext()){
                            Phone p = (Phone)li.next();
                            if(p.name.equals(name)){
                                System.out.println("Enter the number:");
                                String number = sc1.nextLine();
                                li.set(new Phone(name,number));
                                found=true;
                            }
                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Record updated successfully!!");
                            System.out.println("-----------------------------------");
                        }

                    }else{
                        System.out.println("Record not found!!");
                    }

                    break;
                case 6:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Phone>)ois.readObject();
                        ois.close();

                        //Collections.sort();
                    }
            }
        }
        while(choice!=0);
    }
}
