package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
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

import java.util.Collections;

public class BookingStage2 extends Application {

    public void start(Stage stage) {

        GridPane gridBooking = new GridPane();
        gridBooking.setMinSize(400, 200);
        gridBooking.setPadding(new Insets(10, 10, 10, 10));
        gridBooking.setAlignment(Pos.CENTER);
        gridBooking.setVgap(5);
        gridBooking.setHgap(5);
        Button accept = new Button("Accept");
        Button cancel = new Button("Cancel");
        Label bookingHeader = new Label("Booking");
        Text selectMovie = new Text("Movie");
        Text selectDate = new Text("Select Date");
        Text selectSeats = new Text("Seats");
        DatePicker datePicker = new DatePicker();

        MenuItem movie1 = new MenuItem("Interstellar");
        MenuItem movie2 = new MenuItem("Batman: Begins");
        MenuItem movie3 = new MenuItem("Ett Päron Till Farsan: 2");
        MenuButton movieButton = new MenuButton("Select", null, movie1, movie2, movie3);
        //MenuButton seatsButton = new MenuButton("Select", null);

        gridBooking.setHalignment(bookingHeader, HPos.CENTER);
        gridBooking.add(bookingHeader,0,0,2,1);
        bookingHeader.setId("booking-header");
        bookingHeader.setStyle("-fx-text-fill: black; -fx-font-size: 30;");

        gridBooking.add(movieButton, 1,2);
        //gridBooking.add(seatsButton,1,3);
        gridBooking.add(accept, 0,5);
        gridBooking.add(cancel,1,5);
        gridBooking.add(selectMovie, 0,2);
        gridBooking.add(selectDate,0,1);
        gridBooking.add(selectSeats,0,3);
        gridBooking.add(datePicker, 1, 1);

        Scene sceneBS = new Scene(gridBooking);
        stage.setScene(sceneBS);
        stage.setTitle("Booking");
        sceneBS.getStylesheets().add("sample/stylesheet.css");

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                LoginStage1 loginStage1 = new LoginStage1();
                loginStage1.start(stage);
            }
        });

        sceneBS.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

        stage.show();
    }
}
