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

        tourDB.addTour();

    }


    // method updateTour
    // a method that takes in new information about a given tour and updates it in the db

    public void updateTour(){

        tourDB.updateTour();

    }


    // method deleatTour
    // method that takes in a tour id and removes that tour from the database.

    public void deleatTou(int Tour_ID){

        tourDB.deleteTour();

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
