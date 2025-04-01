package Controllers;
import Data.TourDB;
import Objects.Tour;

public class TourController {

    private Tour[] tours = new Tour[20];

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

    }

}
