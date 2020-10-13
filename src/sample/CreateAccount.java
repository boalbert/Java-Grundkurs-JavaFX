package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccount extends Application {


    public void start(Stage stage) {

        GridPane gridCA = new GridPane();
        gridCA.setMinSize(600, 300);
        gridCA.setAlignment(Pos.CENTER);
        gridCA.setPadding(new Insets(10, 10, 10, 10));
        gridCA.setHgap(5);
        gridCA.setVgap(5);

        TextField firstName = new TextField();  firstName.setPromptText("Must contain 3 letters");
        TextField lastName = new TextField();   lastName.setPromptText("Must contain 3 letters");
        TextField email = new TextField();  email.setPromptText("Must contain < @ > ");
        PasswordField password = new PasswordField();   password.setPromptText("Must contain 5 letters");
        PasswordField passwordRe = new PasswordField();   password.setPromptText("Must contain 5 letters");
        Text unText = new Text("First Name"); unText.setId("text");
        Text lnText = new Text("Last Name"); lnText.setId("text");
        Text eText = new Text("Email"); eText.setId("text");
        Text pwText = new Text("Password"); pwText.setId("text");
        Label createHeader = new Label("Create New Account");   createHeader.setId("header-text");
        Button create = new Button("Create");
        Button cancel = new Button("Cancel");
        Text errorText = new Text();
        errorText.setVisible(false);

        create.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        gridCA.add(createHeader, 0, 0, 2, 1);
        gridCA.setHalignment(createHeader, HPos.CENTER);

        gridCA.add(firstName, 1, 1);
        gridCA.add(lastName, 1, 2);
        gridCA.add(email, 1, 3);
        gridCA.add(password, 1, 4);
        gridCA.add(passwordRe,1,5);
        gridCA.add(unText, 0, 1);
        gridCA.add(lnText, 0, 2);
        gridCA.add(eText, 0, 3);
        gridCA.add(pwText, 0, 4);
        gridCA.add(create, 0, 6);
        gridCA.add(cancel, 1, 6);
        gridCA.add(errorText, 0, 7,2,1);
        gridCA.setHalignment(errorText, HPos.CENTER);

        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (password.getText().equals(passwordRe.getText()))    {
                    if (firstName.getLength() >= 3 && lastName.getLength() >= 3 && password.getLength() >= 5 && email.getText().contains("@")) {
                        errorText.setVisible(false);
                        Customer newCustomer = new Customer(firstName.getText(), lastName.getText(), email.getText(), password.getText());
                        Controller.customerMap.put(newCustomer.getEmail(), newCustomer);
                        Save.saveMap(Controller.customerMap);
                        System.out.println("Customer added to HashMap(customerMap)");
                        stage.close();
                        LoginStage1 loginStage1 = new LoginStage1();
                        loginStage1.start(stage);
                    }
                    else {
                        errorText.setText("Please fill out the boxes!");
                        errorText.setVisible(true);
                    }
                }
                else {
                    errorText.setText("Passwords does not match!");
                    errorText.setVisible(true);
                }
            }
        });

        cancel.setCancelButton(true);
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                LoginStage1 loginStage1 = new LoginStage1();
                loginStage1.start(stage);
            }
        });

        Scene sceneCA = new Scene(gridCA);
        stage.setScene(sceneCA);
        stage.setTitle("Create Account");

        sceneCA.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if(key == KeyCode.ESCAPE)   {
                    stage.close();
                    LoginStage1 loginStage1 = new LoginStage1();
                    loginStage1.start(stage);
                }
            }
        });

        sceneCA.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.ENTER)   {
                    if(password.getText().equals(passwordRe.getText())) {
                    if (firstName.getLength() >= 2 && lastName.getLength() >= 2 && password.getLength() >= 5 && email.getText().contains("@")) {
                        errorText.setVisible(false);
                        Customer newCustomer = new Customer(firstName.getText(), lastName.getText(), email.getText(), password.getText());
                        Controller.customerMap.put(newCustomer.getEmail(), newCustomer);
                        Save.saveMap(Controller.customerMap);
                        System.out.println("Customer added to HashMap(customerMap)");
                        stage.close();
                        LoginStage1 loginStage1 = new LoginStage1();
                        loginStage1.start(stage);
                    }
                    else {
                        errorText.setText("Please fill out the boxes");
                        errorText.setVisible(true);
                    }
                    }
                    else {
                        errorText.setText("Passwords do not match");
                        errorText.setVisible(true);
                    }
                }
            }
        });
        sceneCA.getStylesheets().add("sample/stylesheet.css");
        stage.show();
    }
}
