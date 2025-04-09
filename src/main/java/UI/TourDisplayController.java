package UI;

import java.io.IOException;
import Controllers.UserController;
import javax.swing.UIDefaults.ActiveValue;

import Controllers.UserController;
import Objects.Tour;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TourDisplayController {

    private Stage stage;
    private Scene scene;

    private Tour currentTour;

    @FXML
    private VBox detailsContainer;

    @FXML
    private Button bookButton;

    public void inputDetails(Tour tour) {
        if (tour == null) {
            return;
        }

        this.currentTour = tour;
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

    public void bookTour(ActionEvent event) throws IOException{
        if (currentTour == null) return;

        if (currentTour.getAvailable_seats() > 0) {

            //Lower available seat count and display correct tour info
            currentTour.setAvailable_seats(currentTour.getAvailable_seats() - 1); 
            inputDetails(currentTour);

            //Confirm booking
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Booking Confirmed");
            alert.setHeaderText(null);
            alert.setContentText("You have successfully booked the tour: " + currentTour.getTourName());
            alert.showAndWait();
        } else {
            //Alert booking fail
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Booking Failed");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, no available seats left.");
            alert.showAndWait();
        }

        //Input the tour into booking scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tour_list.fxml"));
        Parent root = loader.load();

        UserController userController = loader.getController();
        userController.inputBooking(currentTour);
    }

    @FXML
    private void openUserPopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user.fxml"));
        Parent root = loader.load();

        Stage userStage = new Stage();
        userStage.setTitle("User Window");
        userStage.setScene(new Scene(root));
        userStage.show();
    }

    @FXML
    private void openUserPopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user.fxml"));
        Parent root = loader.load();

        UserController userController = loader.getController();
        userController.inputBooking(currentTour);

        Stage userStage = new Stage();
        userStage.setTitle("User Window");
        userStage.setScene(new Scene(root));
        userStage.show();
    }
}
