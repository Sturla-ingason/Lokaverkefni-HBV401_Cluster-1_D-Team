package Data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import Objects.Tour;

import java.sql.*;

public class TourDB {

    /*
     * Establishes a connection with the data base
     * returns a connection with the database
     */
    public Connection getConnection(){

        try {
            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

            return conn;

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();

            return null;
        }

    }


    /*
     * method that allows us to get all the tours in the data base
     * returns all tours in the data base.
     */
    public List<Tour> getAllTours(){
        List<Tour> allTours = new ArrayList<>();

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String querry = "SELECT * FROM tour";

            ResultSet result = statement.executeQuery(querry);
            while(result.next()){
                Tour tourTemp = new Tour(result.getInt("tourID"), 
                result.getInt("admin_ID"),
                result.getString("tourName"),
                result.getString("Date"),
                result.getInt("price"),
                result.getInt("duration"),
                result.getString("region"),
                result.getInt("available_seats"),
                result.getString("category"),
                result.getString("language"),
                result.getString("description"));

                allTours.add(tourTemp);
            }
            
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }

        return allTours;
    }
    

    //Takes in Tour object
    /*
     * method that allows us to add a tour to the data base
     * takes in a tour object
     */
    public void addTour(Tour tour){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String insert_querry = "INSERT INTO tour(tourID, admin_ID, tourName, Date, price, duration, region, available_seats, category, language, description)";
            String value_querry = "VALUES(" + 
                tour.getTour_ID() +","+ 
                tour.getAdmin_ID() +","+ 
                tour.getTourName() +","+ 
                tour.getLocalDate() +","+ 
                tour.getPrice() +","+ 
                tour.getDuration() +","+ 
                tour.getRegion() +","+ 
                tour.getAvailable_seats() +","+ 
                tour.getCatagory() +","+ 
                tour.getLanguage() +","+ 
                tour.getDescription() +")" ;
            
            statement.executeQuery(insert_querry + value_querry);

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }


    // Takes in tour object
    /*
     * method that allows us to update the information for a tour
     * takes in one tour object
     */
    public void updateTour(Tour tour){


        try {
            
            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String tour_to_update = "UPDATE tour set(tourID, admin_ID, tourName, Date, price, duration, region, available_seats, category, language, description)";
            String value_querry = "VALUES(" + tour.getTour_ID() +","+ 
            tour.getAdmin_ID() +","+ 
            tour.getTourName() +","+ 
            tour.getLocalDate() +","+ 
            tour.getPrice() +","+ 
            tour.getDuration() +","+ 
            tour.getRegion() +","+ 
            tour.getAvailable_seats() +","+ 
            tour.getCatagory() +","+ 
            tour.getLanguage() +","+ 
            tour.getDescription() +")" ;

            statement.executeQuery(tour_to_update + value_querry + "where tourID = " + tour.getTour_ID());

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }


    public void deleteTour(Tour tour){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String deleate_querry = "DELETE FROM tour WHERE tourID = " + tour.getTour_ID();

            statement.executeQuery(deleate_querry);

            
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }

}
