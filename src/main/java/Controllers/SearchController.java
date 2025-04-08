package Controllers;

import Data.TourDB;
import java.util.*;
import Objects.Tour;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;


public class SearchController {

    @FXML
    private ListView<String> tourListView;

    public void setTourListView(ListView<String> tourListView) {
        this.tourListView = tourListView;
    }

    
    // Fyllir listview með tours
    public void updateListView(List<Tour> tours) {
        if (tourListView != null) {
            List<String> tourNames = new ArrayList<>();
            for (Tour tour : tours) {
                tourNames.add(tour.getTourName());
            }
            tourListView.getItems().setAll(tourNames);
        } else {
            System.out.println("tourListView is null");
        }
    }
    
    
    private TourDB tourDB = new TourDB();
    private List<Tour> tours = new ArrayList<>();

    // uppfærum tours listan okkar ef við uppfærum einhverja tours
    public void updateTours(){
        tours = tourDB.getAllTours();
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
    
    /*
     * Searches all the tours in tha data base and checks if they match the query string
     * @param query = the string to search for
     * @return a list of all the matching tours
     */
    public List<Tour> stringSearch(String query){
        List<Tour> matchingTours = new ArrayList<>();
        List<String> tourNames = new ArrayList<>();

        for(Tour tour : tours){
            if(tour.getTourName().toLowerCase().contains(query.toLowerCase()) && query.length() != 0){
                matchingTours.add(tour);
            }
        }
        
        for (Tour tour : matchingTours) {
            tourNames.add(tour.getTourName());
        }
        tourListView.getItems().setAll(tourNames);

        return matchingTours;
    }


    /*
     * Searches all the tours in the data base 
     */
    public List<Tour> priceSearch(double min, double max){

        List<Tour> matchingTours = new ArrayList<>();

        for(Tour tour: tours){
            if(tour.getPrice() < max && tour.getPrice() > min){
                matchingTours.add(tour);
            }
        }

        return matchingTours;

    }


    public Tour[] dateSearch(){
        Tour[] tour = new Tour[10];

        // Tekur inn tvær breytur. date_form og date_too

        // Kallar á aðferð í TourDB til að finna alla þá tours sem eru á milli data_from og date_too

        // Skilar lista af öllum þeim tours sem uppfylla skilirðinn

        return tour;
    }


    public List<Tour> regionSearch(String region){
        List<Tour> matchingTours = new ArrayList<>();
    
        for(Tour tour : tours){
            if(tour.getRegion().toLowerCase().contains(region.toLowerCase())){
                matchingTours.add(tour);
            }
        }

        return matchingTours;
    }

}