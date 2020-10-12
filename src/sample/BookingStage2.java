package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
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

        MenuItem movie1 = new MenuItem("Interstellar");
        MenuItem movie2 = new MenuItem("Batman: Begins");
        MenuItem movie3 = new MenuItem("Ett Päron Till Farsan: 2");
        MenuButton movieButton = new MenuButton("Select", null, movie1, movie2, movie3);
        MenuButton seatsButton = new MenuButton("Select", null);


        gridBooking.setHalignment(bookingHeader, HPos.CENTER);
        gridBooking.add(bookingHeader,0,0,2,1);
        bookingHeader.setId("booking-header");

        gridBooking.add(movieButton, 1,1);
        gridBooking.add(accept, 0,5);
        gridBooking.add(cancel,1,5);
        gridBooking.add(selectMovie, 0,1);
        gridBooking.add(selectDate,0,2);
        gridBooking.add(selectSeats,0,3);

        Scene sceneBS = new Scene(gridBooking);
        stage.setScene(sceneBS);
        stage.setTitle("Booking");
        sceneBS.getStylesheets().add("sample/stylesheet.css");
        stage.show();
    }
}
