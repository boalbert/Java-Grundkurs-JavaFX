package sample;

import javafx.application.Application;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        // Loading database's
        Save.readFile();
        Save.readMovieFile();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Setting LoginStage1 as first primaryStage
        LoginStage1 stage1 = new LoginStage1();
        stage1.start(primaryStage);
        primaryStage.show();
    }
}
