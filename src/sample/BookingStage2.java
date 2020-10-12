package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookingStage2 extends Application {

    public void start(Stage stage) {

        stage.setTitle("Booking");

        // Header
        Text tHeader = new Text("Book");
        // Setting ID for stylesheet
        tHeader.setId("header-text");

        // Created GridPane
        GridPane gridPane = new GridPane();

        // Added placeholder text
        gridPane.add(tHeader, 0, 0);

        // Creating scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        //Setting stylesheet
        scene.getStylesheets().add("sample/stylesheet.css");

        stage.show();


    }
}
