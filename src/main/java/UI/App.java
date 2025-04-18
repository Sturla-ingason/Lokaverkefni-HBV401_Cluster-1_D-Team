package UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Controllers.TourController;
import Controllers.SearchController;

public class App extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        
        System.out.println(getClass().getResource("/primary.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/primary.fxml"));
        Parent root = fxmlLoader.load();

        TourController tourController = new TourController();
        tourController.init();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }



}