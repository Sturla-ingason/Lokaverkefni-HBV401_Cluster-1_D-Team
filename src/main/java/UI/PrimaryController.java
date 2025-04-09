package UI;

import Controllers.BookingController;
import Controllers.ReviewController;
import Controllers.SearchController;
import Controllers.TourController;
import Controllers.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import Data.BookingDB;
import Data.TourDB;
import Objects.Tour;

public class PrimaryController {

    @FXML
    SearchController searchController = new SearchController();

    @FXML
    BookingController bookingController = new BookingController();
    @FXML
    ReviewController reviewController = new ReviewController();
    @FXML
    TourController tourController = new TourController();
    @FXML
    UserController userController = new UserController();

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> tourListView;

    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private List<Tour> tours = new ArrayList<>();
    BookingDB test = new BookingDB();

    private TourDB tourDB = new TourDB();
    
    @FXML
    public void initialize() {
        System.out.println("initialized!");
        tours = tourDB.getAllTours();

        searchController.setTourListView(tourListView); 
        searchController.updateListView(tours);
    }

     
    @FXML
    private void handleSearchInput() {
        String query = searchField.getText();
        searchController.stringSearch(query);
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        test.getAllBookings();
    }

    public void displayTour(MouseEvent event) throws IOException{
        String selectedName = tourListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedName);

        Tour selectedTour = null;

        for (Tour tour : tours){
            if (tour.getTourName().equals(selectedName)) {
                selectedTour = tour;
                break;
            }
        }

        System.out.println(selectedTour);
        if (selectedTour != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tour.fxml"));
            root = loader.load();
            TourDisplayController tourDisplay = loader.getController();
            tourDisplay.inputDetails(selectedTour);
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}