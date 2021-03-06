package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginStage1 extends Application {

    public void start(Stage stage) {

        stage.setTitle("Login");

        // Header
        Label lblHeader = new Label("Sign In");
        // Setting ID for stylesheet
        lblHeader.setId("header-text");

        // Email and Password
        TextField tfEmail = new TextField();
        tfEmail.setPromptText("E-Mail");
        PasswordField tfPassword = new PasswordField();
        tfPassword.setPromptText("Password");

        // Text for displaying error messages!
        Text errorText = new Text("Wrong Username/Email or Password!");
        errorText.setVisible(false);

        // Buttons
        Button btnCreateAccount = new Button("Create Account");
        btnCreateAccount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnCreateAccount.setOnAction(actionEvent -> {
            // Kod för att gå till Stage1.1CreateAccount
            CreateAccount createAccount = new CreateAccount();
            createAccount.start(stage);
        });



        Button btnExit = new Button("Exit");
        btnExit.setCancelButton(true);
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                stage.close();
            }
        });

        Button btnLogin = new Button("Login");
        btnLogin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnLogin.setOnAction(actionEvent -> {
            if (Controller.customerMap.containsKey(tfEmail.getText()))    {
                System.out.println("Username accepted");
                if (tfPassword.getText().equals(Controller.customerMap.get(tfEmail.getText()).getPassword())) {
                    System.out.println("Password accepted");
                    errorText.setVisible(false);
                    Controller.currentUser = tfEmail.getText();
                    BookingStage2 bookingStage2 = new BookingStage2();
                    bookingStage2.start(stage);

                }
                else {
                    errorText.setText("Wrong Password!");
                    errorText.setVisible(true);
                }
            }
            else {
                errorText.setText("Wrong Username!");
                errorText.setVisible(true);
            }
        });

        // Created GridPane
        GridPane gridPane = new GridPane();

        // Formatting GridPane
        gridPane.setMinSize(400, 400);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Error text
        gridPane.add(errorText,0,3,2,1);
        gridPane.setHalignment(errorText, HPos.CENTER);

        // Added placeholder text
        gridPane.add(lblHeader, 0, 0, 2, 1);
        // Centering lblHeader
        GridPane.setHalignment(lblHeader, HPos.CENTER);
        gridPane.setValignment(btnExit, VPos.BOTTOM);
        gridPane.setHalignment(btnExit, HPos.LEFT);


        // Textfields
        gridPane.add(tfEmail, 0, 3);
        gridPane.add(tfPassword, 1, 3);
        gridPane.add(Controller.copyright,0,12);
        // Button
        gridPane.add(btnCreateAccount, 0, 4);
        gridPane.add(btnLogin, 1, 4);
        gridPane.add(btnExit,0,9);

        // Creating scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        // Setting stylesheet
        scene.getStylesheets().add("sample/stylesheet.css");

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.P) {
                    Controller.printAll();
                }
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.ENTER)   {
                    if (Controller.customerMap.containsKey(tfEmail.getText()))    {
                        System.out.println("Username accepted");
                        if (tfPassword.getText().equals(Controller.customerMap.get(tfEmail.getText()).getPassword())) {
                            System.out.println("Password accepted");
                            errorText.setVisible(false);
                            Controller.currentUser = tfEmail.getText();
                            BookingStage2 bookingStage2 = new BookingStage2();
                            bookingStage2.start(stage);
                        }
                        else {
                            errorText.setText("Wrong Password!");
                            errorText.setVisible(true);
                        }
                    }
                    else {
                        errorText.setText("Wrong Username!");
                        errorText.setVisible(true);
                    }
                }
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if(key == KeyCode.ESCAPE)   {
                    stage.close();
                }
            }
        });

        stage.show();
    }
}
