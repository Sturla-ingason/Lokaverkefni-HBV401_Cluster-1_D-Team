package UI;

import java.io.IOException;

import Objects.Tour;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TourDisplayController {

    private Stage stage;
    private Scene scene;

    public void inputDetails(Tour tour, VBox detailsContainer) {
        if (tour == null || detailsContainer == null) {
            return;
        }
        
        detailsContainer.getChildren().clear();

        Label tourName = new Label("Title: " + tour.getTourName());
        tourName.setStyle("-fx-font-weight: bold");

        detailsContainer.getChildren().addAll(
            tourName,
            new Label("Description: " + tour.getDescription()),
            new Label("Duration: " + tour.getDuration()),
            new Label("Available seats: " + tour.getAvailable_seats()),
            new Label("Category: " + tour.getCatagory()),
            new Label("Language: " + tour.getLanguage()),
            new Label("Date: " + tour.getLocalDate()),
            new Label("Price: $" + tour.getPrice()),
            new Label("Region: " + tour.getRegion())
    );
}

    public void returnToMain(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/primary.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
