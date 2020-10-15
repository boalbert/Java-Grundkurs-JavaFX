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

public class BookingStage2 extends Application {

    public void start(Stage stage) {

        GridPane gridBooking = new GridPane();
        gridBooking.setMinSize(400, 400);
        gridBooking.setPadding(new Insets(10, 10, 10, 10));
        gridBooking.setAlignment(Pos.CENTER);
        gridBooking.setVgap(5);
        gridBooking.setHgap(2);

        Button cancel = new Button("Cancel");
        Label bookingHeader = new Label("Booking");
        bookingHeader.setId("header-text");
        Text selectMovie = new Text("Movie");
        Text selectDate = new Text("Select Date");
        Text selectSeats = new Text("Seats");
        Text confirmAge = new Text("Over age 18 ");
        DatePicker datePicker = new DatePicker();
        CheckBox checkBox = new CheckBox("Confirm age");

        ObservableList<String> optionsMovies =
            FXCollections.observableArrayList(
                "Interstellar"
            );
        final ComboBox comboBoxMovies = new ComboBox(optionsMovies);

        ObservableList<Integer> optionsSeasts =
                FXCollections.observableArrayList(
                        1,2,3,4,5,6,7,8,9,10
                );
        final ComboBox comboBoxSeats = new ComboBox(optionsSeasts);

        Button accept = new Button("Confirm");
        accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (checkBox.isSelected()) {
                    Recipe.createID();
                    Controller.choiceMovie = comboBoxMovies.getValue().toString();
                    Controller.choiceDate = datePicker.getValue().toString();
                    Controller.choiceSeats = (int) comboBoxSeats.getValue();

                    stage.close();
                    OrderConfirmation orderConfirmation = new OrderConfirmation();
                    orderConfirmation.start(stage);
                }
                else System.out.println("Error in accept.setOnAction in BookingStage2");
            }
        });

        gridBooking.setHalignment(bookingHeader, HPos.CENTER);
        gridBooking.add(bookingHeader,0,0,2,1);

        gridBooking.add(comboBoxMovies, 1,2);
        gridBooking.add(comboBoxSeats,1,3);

        gridBooking.add(selectMovie, 0,2);
        gridBooking.add(selectDate,0,1);
        gridBooking.add(selectSeats,0,3);
        gridBooking.add(datePicker, 1, 1);

        gridBooking.add(confirmAge,0,5);
        gridBooking.add(checkBox,1,5);
        gridBooking.add(accept, 1,8);
        gridBooking.add(cancel,1,9);
        gridBooking.add(Controller.copyright,0,12);

        Scene sceneBS = new Scene(gridBooking);
        stage.setScene(sceneBS);
        stage.setTitle("Booking");

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

        sceneBS.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (checkBox.isSelected()) {
                    KeyCode key = keyEvent.getCode();
                    if (key == KeyCode.ENTER) {
                        Recipe.createID();

                        Controller.choiceMovie = comboBoxMovies.getValue().toString();
                        Controller.choiceDate = datePicker.getValue().toString();
                        Controller.choiceSeats = (int) comboBoxSeats.getValue();

                        stage.close();
                        OrderConfirmation orderConfirmation = new OrderConfirmation();
                        orderConfirmation.start(stage);
                    }
                }
            }
        });

        sceneBS.getStylesheets().add("sample/stylesheet.css");
        stage.show();
    }
}
