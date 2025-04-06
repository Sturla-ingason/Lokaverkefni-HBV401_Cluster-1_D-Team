package Data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import Objects.Tour;

import java.sql.*;

public class TourDB {

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
    public void addTour(){

        try {

            Tour tour = new Tour(0, 0, null, null, 0, 0, null, 0, null, null, null);

            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

            Statement statement = conn.createStatement();

            String insert_querry = "INSERT INTO tour(tourID, admin_ID, tourName, Date, price, duration, region, available_seats, category, language, description)";
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
            
            statement.executeQuery(insert_querry + value_querry);

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }


    // Takes in tour object
    public void updateTour(){

        Tour tour = new Tour(0, 0, null, null, 0, 0, null, 0, null, null, null);

        try {
            
            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

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


    public void deleteTour(){

        try {

            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

            
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }

}
