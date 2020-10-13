package sample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Payment extends Application {

    @Override
    public void start(Stage stage) {


        //DropDown menu for payment options
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Mastercard",
                        "Visa card",
                        "American Express");

        final ComboBox cbPaymentOptions= new ComboBox(options);
        cbPaymentOptions.setPromptText("Credit Card Options");

        TextField tfCreditCardNumber = new TextField();
        tfCreditCardNumber.setPromptText("xxxx xxxx xxxx xxxx");

        TextField tfValid = new TextField();
        tfValid.setPromptText("Valid Thru (month-year)");

        PasswordField cvvField = new PasswordField();
        cvvField.setPromptText("CVV");

        Button btnConfirm = new Button("Confirm Payment");

        Button btnCancel = new Button("Cancel");

        CheckBox terms = new CheckBox(" I accept the Terms & Conditions");

        Label lbCreditCardNumber = new Label("Credit Card Number");
        Label lbValid = new Label("Valid Thru");
        Label lbCVV = new Label("CVV");


        Text tInfo = new Text("©CinemaTix AB, 23143 Jönköping");
        tInfo.setStyle("-fx-font-size: 60%");

        GridPane gridPane4 = new GridPane();
        gridPane4.setVgap(10);
        gridPane4.setHgap(10);
        gridPane4.setAlignment(Pos.CENTER);

        gridPane4.add(cbPaymentOptions,1,1);

        gridPane4.add(lbCreditCardNumber,0,2);
        gridPane4.add(tfCreditCardNumber,1,2);

        gridPane4.add(lbValid,0,3);
        gridPane4.add(tfValid,1,3);

        gridPane4.add(lbCVV,0,4);
        gridPane4.add(cvvField,1,4);

        gridPane4.add(terms,1,6);

        gridPane4.add(btnConfirm,1,7);
        gridPane4.add(btnCancel,1,8);

        gridPane4.add(tInfo,0,10);

        stage.setTitle("Payment");
        Scene scene= new Scene(gridPane4, 400, 400);
        stage.setScene(scene);

        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                stage.close();
                CompletedOrder completedOrder = new CompletedOrder();
                completedOrder.start(stage);
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                LoginStage1 loginStage1 = new LoginStage1();
                loginStage1.start(stage);
            }
        });

        stage.show();
    }
}
