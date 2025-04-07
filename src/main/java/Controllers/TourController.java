package Controllers;
import java.util.ArrayList;

import java.util.*;

import Data.TourDB;
import Objects.Tour;

public class TourController {

    List<Tour> tours = new ArrayList<>();
    private TourDB tourDB = new TourDB();


    // method addTour
    // a method that adds a tour to the data base.
    // creates a new tour 

    public void addTour(){

        Tour tour = new Tour(0, 0, null, null, 0, 0, null, 0, null, null, null);

        tourDB.addTour(tour);

    }


    // method updateTour
    // a method that takes in new information about a given tour and updates it in the db

    public void updateTour(){

        //TODO take input from UI to make a new tour element with the updates
        Tour tour = new Tour(0, 0, null, null, 0, 0, null, 0, null, null, null);

        tourDB.updateTour(tour);

    }


    // method deleatTour
    // method that takes in a tour id and removes that tour from the database.

    public void deleatTour(int Tour_ID){

        //TODO take input from UI to know what tour to delete
        Tour tour = new Tour(Tour_ID, Tour_ID, null, null, Tour_ID, Tour_ID, null, Tour_ID, null, null, null);

        tourDB.deleteTour(tour);

    }

    /*
     * Settar tours ef einhverjar breytringar verða á þeim
     */
    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }


    /*
     * Loadar öllum tours úr data baseinnu inn í controllerin þegar að við byrjum.
     */
    public void init(){
        tours = tourDB.getAllTours();
        
        for(Tour tour: tours){
            System.out.println(tour.getTourName());
        }

    }


}
