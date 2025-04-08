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
import javafx.scene.control.ListView;
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


    
    private List<Tour> tours = new ArrayList<>();
    BookingDB test = new BookingDB();
    
    @FXML
    public void initialize() {
        System.out.println("initialized!");
        
        searchController.setTours(tours); 
        searchController.updateListView();
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
}