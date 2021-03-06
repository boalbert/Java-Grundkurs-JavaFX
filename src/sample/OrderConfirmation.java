package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrderConfirmation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Creating and formatting Gridpane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400,400);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Header text
        Label label = new Label("Order Confirmation - OrderID-["+Controller.currentID+"]");
        label.setId("header-text");

        Text text1 = new Text("Movie: "+ Controller.choiceMovie);
        Text text2 = new Text("Seats: "+Controller.choiceSeats);
        Text text3 = new Text("Date: "+Controller.choiceDate);

        Button accept = new Button("Accept");
        Button cancel = new Button("Cancel");

        gridPane.add(label,0,0);
        gridPane.add(text1,0,1);
        gridPane.add(text2,0,2);
        gridPane.add(text3,0,3);
        gridPane.add(accept,0,4);
        gridPane.add(cancel,0,5);
        gridPane.add(Controller.copyright,0,6);

        Scene sceneOC = new Scene(gridPane);
        stage.setScene(sceneOC);
        stage.setTitle("Order Confirmation");

        accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                Payment payment = new Payment();
                payment.start(stage);
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                BookingStage2 bookingStage2 = new BookingStage2();
                bookingStage2.start(stage);
            }
        });

        sceneOC.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.ENTER)   {
                    stage.close();
                    Payment payment = new Payment();
                    payment.start(stage);
                }
            }
        });

        sceneOC.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.ESCAPE)  {
                    stage.close();
                    BookingStage2 bookingStage2 = new BookingStage2();
                    bookingStage2.start(stage);
                }
            }
        });

        sceneOC.getStylesheets().add("sample/stylesheet.css");
        stage.show();

    }
}
