package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static HashMap<String, Customer> customerMap = new HashMap<>();
    public static HashMap<String, Movies> moviesHashMap = new HashMap<>();
    public static ArrayList<Movies> moviesArrayList = new ArrayList<>();

    public static String choiceMovie;
    public static String choiceSeats;
    public static String choiceDate;

    public static void printMap() {
        for (Map.Entry<String, Customer> m : Controller.customerMap.entrySet()) {
            System.out.println((m.getKey() + "=" + m.getValue()));
        }
    }

    public static void printMovieMap() {
        for (Map.Entry<String, Movies> m : Controller.moviesHashMap.entrySet()) {
            System.out.println((m.getKey() + "=" + m.getValue()));
        }
    }

}
