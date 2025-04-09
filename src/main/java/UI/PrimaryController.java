package UI;

import Controllers.BookingController;
import Controllers.ReviewController;
import Controllers.SearchController;
import Controllers.TourController;
import Controllers.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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

    @FXML
    private MenuButton regionMenuButton; 
    
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
    private void handleSearchButton() {
        String query = searchField.getText();
        tours = tourDB.getAllTours();
        searchController.setTours(tours);
        searchController.stringSearch(query);
    }
    

private String selectedRegion = ""; // Store selected region

    @FXML
    private void handleRegionSelection(ActionEvent event) {
    MenuItem menuItem = (MenuItem) event.getSource();
    selectedRegion = menuItem.getText(); 
    regionMenuButton.setText(selectedRegion); 

    // Perform search based on region
    tours = tourDB.getAllTours(); 
    searchController.setTours(tours);
    List<Tour> filteredTours = searchController.regionSearch(selectedRegion);
    searchController.updateListView(filteredTours);
}


    @FXML
    private void switchToSecondary() throws IOException {
        test.getAllBookings();
    }
}