package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Save.readFile();
        Customer test = new Customer("Casper","Konyi","casper.konyi@iths.se","casper123");
        Controller.customerMap.put(test.getEmail(), test);
        Save.saveMap(Controller.customerMap);
        Controller.printMap();

        Save.readMovieFile();
        Movies movie1 = new Movies("Interstellar");
        Controller.moviesHashMap.put(movie1.getTitle(), movie1);
        Save.saveMovieMap(Controller.moviesHashMap);
        Controller.printMovieMap();

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
