package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Save {

    public static void loadDatabases()  {
        readFile();
        readMovieFile();
        readRecipeFile();
        readIdArray();
        readPaymentsFile();
    }

    // Customer
    public static void saveMap(HashMap<String, Customer> map) {

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

    public static void readFile() {
        try {
            FileInputStream fis = new FileInputStream("CustomerDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, Customer> mapInFile = (HashMap<String, Customer>) ois.readObject();
            ois.close();
            fis.close();

            Controller.customerMap = mapInFile;
            System.out.println("Loading Customer-Database...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Movies
    public static void saveMovieMap(HashMap<String, Movies> map) {

        try {
            File file = new File("MovieDatabase");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Movies has been updated!");
    }

    public static void readMovieFile() {
        try {
            FileInputStream fis = new FileInputStream("MovieDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, Movies> mapInFile = (HashMap<String, Movies>) ois.readObject();
            ois.close();
            fis.close();

            Controller.moviesHashMap = mapInFile;
            System.out.println("Loading Movie-Database...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Recipe
    public static void saveRecipe(HashMap<Integer, Recipe> map) {
        try {
            File file = new File("RecipeDatabase");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Recipes updated");
    }

    public static void readRecipeFile() {
        try {
            FileInputStream fis = new FileInputStream("RecipeDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<Integer, Recipe> mapInFile = (HashMap<Integer, Recipe>) ois.readObject();
            ois.close();
            fis.close();

            Controller.recipesMap = mapInFile;
            System.out.println("Loading Recipe-Database...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // IDs
    public static void writeIdArray(ArrayList<Integer> id)    {
        try {
            File file = new File("IdDatabase");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(id);

            oos.close();
            fos.close();
        }catch (IOException e)  { e.printStackTrace(); }
        System.out.println("IDs has been updated");
        }

    public static void readIdArray()    {
        try {
            FileInputStream fis = new FileInputStream("IdDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Integer> listInFile = (ArrayList<Integer>) ois.readObject();
            ois.close();
            fis.close();

            Controller.recipeIDs = listInFile;
            System.out.println("Loading IDs...");
        } catch (Exception e) { e.printStackTrace(); }
    }


    //Payments
    public static void writePayments(HashMap<Integer, PaymentRecipe> payments) {
        try {
            File file = new File("PaymentsDatabase");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(payments);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Payments updated");
    }

    public static void readPaymentsFile() {
        try {
            FileInputStream fis = new FileInputStream("PaymentsDatabase");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<Integer, PaymentRecipe> mapInFile = (HashMap<Integer, PaymentRecipe>) ois.readObject();
            ois.close();
            fis.close();

            Controller.payments = mapInFile;
            System.out.println("Loading Payments-Database...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






