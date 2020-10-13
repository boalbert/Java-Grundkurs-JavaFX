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
    public static ArrayList<Movies> moviesArrayList = new ArrayList<>();

    public static String choiceMovie;
    public static String choiceSeats;
    public static String choiceDate;

    final public static Text copyright = new Text("Copyright @ JCAJ inc. 2020");

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
