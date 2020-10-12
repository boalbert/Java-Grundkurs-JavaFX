package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Save {

    public static void saveMap(HashMap<String,Customer> map) {

        try {
            File file = new File("CustomerDatabase");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Map has been updated!");
    }

    public static void readFile()   {
        try {
            FileInputStream fis = new FileInputStream("CustomerDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String,Customer> mapInFile = (HashMap<String,Customer>)ois.readObject();
            ois.close();
            fis.close();

            Controller.customerMap = mapInFile;
            System.out.println("Loading Customer-Database...");

        } catch(Exception e) { e.printStackTrace(); }
    }
}



