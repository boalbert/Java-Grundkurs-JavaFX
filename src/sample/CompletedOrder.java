package sample;

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

public class CompletedOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage finalStage) {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400,200);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));

        Label label = new Label("Order Complete"); label.setId("header-text");
        label.setText("Ticket Recipe");
        TextArea ticketInfo = new TextArea(
                "Name: "+Controller.customerMap.get(Controller.currentUser).getFirstName() +
                " "+ Controller.customerMap.get(Controller.currentUser).getLastName() +
                "\nEmail: " + Controller.customerMap.get(Controller.currentUser).getEmail() +
                "\n\nMovie: " + Controller.choiceMovie + "\nSeats: "+ Controller.choiceSeats+
                "\nDate: "+ Controller.choiceDate);
        ticketInfo.setEditable(false);

        Button buttonExit = new Button("Exit");
        buttonExit.setAlignment(Pos.BOTTOM_CENTER);

        gridPane.add(label,0,0);
        gridPane.add(ticketInfo,0,1);
        gridPane.add(buttonExit,0,2);
        gridPane.add(Controller.copyright,0,3);

        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                finalStage.close();
                LoginStage1 loginStage1 = new LoginStage1();
                loginStage1.start(finalStage);
            }
        });

        Scene sceneCO = new Scene(gridPane);
        finalStage.setScene(sceneCO);
        finalStage.setTitle("Ticket Recipe");
        sceneCO.getStylesheets().add("sample/stylesheet.css");
        finalStage.show();
    }
}
