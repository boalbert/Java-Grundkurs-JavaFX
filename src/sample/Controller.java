package sample;

import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static HashMap<String, Customer> customerMap = new HashMap<>();
    public static HashMap<String, Movies> moviesHashMap = new HashMap<>();
    public static HashMap<Integer, Recipe>  recipesMap = new HashMap<>();
    public static ArrayList<Integer> recipeIDs = new ArrayList<>();
    public static HashMap<Integer, PaymentRecipe> payments = new HashMap<>();

    public static String choiceMovie;
    public static int choiceSeats;
    public static String choiceDate;

    final public static Text copyright = new Text("Copyright @ JCAJ inc. 2020");
    public static Text loggedIn = new Text();
    public static String currentUser;
    public static int currentID;

    public static void printAll()   {
        System.out.println("\n\nCustomer-Map");
        printMap();
        System.out.println("\n\nMovie-Map");
        printMovieMap();
        System.out.println("\n\nPayment-Map");
        printPayments();
        System.out.println("\n\nRecipe-Map");
        printRecipe();
    }

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
    public static void printPayments() {
        for (Map.Entry<Integer, PaymentRecipe> m : Controller.payments.entrySet()) {
            System.out.println((m.getKey() + "=" + m.getValue()));
        }
    }
    public static void printRecipe() {
        for (Map.Entry<Integer, Recipe> m : Controller.recipesMap.entrySet()) {
            System.out.println((m.getKey() + "=" + m.getValue()));
        }
    }
}
