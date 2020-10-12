package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccount extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        GridPane gridCA = new GridPane();
        gridCA.setMinSize(400, 200);
        gridCA.setAlignment(Pos.CENTER);
        gridCA.setPadding(new Insets(10, 10,10,10));
        gridCA.setHgap(5);
        gridCA.setVgap(5);

        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last name");
        TextField email = new TextField("Email");
        PasswordField password = new PasswordField();

        gridCA.add(firstName, 0, 1);
        gridCA.add(lastName, 0,2);
        gridCA.add(email,0,3);
        gridCA.add(password,0,4);

        firstName.setStyle("-fx-text-fill: black");
        lastName.setStyle("-fx-text-fill: black");
        email.setStyle("-fx-text-fill: black");

        Scene sceneCA = new Scene(gridCA);
        stage.setScene(sceneCA);
        stage.setTitle("Create Account");
        stage.show();

}
}
