package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginStage1 extends Application {

    public void start(Stage stage) throws Exception{

        stage.setTitle("Login");

        // Header
        Text tHeader = new Text("Login");
        // Setting ID for stylesheet
        tHeader.setId("header-text");

        // Created GridPane
        GridPane gridPane = new GridPane();

        // Added placeholder text
        gridPane.add(tHeader,0,0);

        // Creating scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        // Setting stylesheet
        scene.getStylesheets().add("sample/stylesheet.css");

        stage.show();


    }


}
