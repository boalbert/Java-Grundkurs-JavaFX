package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class LoginStage1 extends Application {

    public void start(Stage stage) throws Exception{

        stage.setTitle("Login");

        // Header
        Label lblHeader = new Label("Login");
        // Setting ID for stylesheet
        lblHeader.setId("header-text");

        // Email and Password
        TextField tfEmail= new TextField();
        tfEmail.setPromptText("E-Mail");
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        // Buttons
        Button btnCreateAccount = new Button("Create Account");
        btnCreateAccount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // TODO Add functionality for Create account -> Go to Stage1.1
        btnCreateAccount.setOnAction(actionEvent -> {
            // Kod för att gå till Stage1.1CreateAccount
        });

        Button btnLogin = new Button("Login");
        btnLogin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // TODO Add functionality for Login -> Go to Booking Scene
        btnLogin.setOnAction(actionEvent -> {

        });


        // Created GridPane
        GridPane gridPane = new GridPane();

        // Formatting GridPane
        gridPane.setMinSize(400,400);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Added placeholder text
        gridPane.add(lblHeader,0,0,2,1);
        // Centering lblHeader
        GridPane.setHalignment(lblHeader, HPos.CENTER);


        // Textfields
        gridPane.add(tfEmail,0,1);
        gridPane.add(tfPassword,1,1);
        // Button
        gridPane.add(btnCreateAccount,0,2);
        gridPane.add(btnLogin,1,2);



//
//        GridPane.setFillWidth(btnLogin, true);
//        GridPane.setFillHeight(btnLogin, true);

        // Creating scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        // Setting stylesheet
        scene.getStylesheets().add("sample/stylesheet.css");

        stage.show();


    }


}