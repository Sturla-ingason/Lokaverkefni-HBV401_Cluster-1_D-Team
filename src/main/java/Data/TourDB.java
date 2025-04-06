package Data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import Objects.Tour;

import java.sql.*;

public class TourDB {

    public List<Tour> getAllTours(){
        List<Tour> allTours = new ArrayList<>();

        try {

            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

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
    
    public void addTour(){

    }

    public void updateTour(){

    }

    public void deleteTour(){

    }

}
