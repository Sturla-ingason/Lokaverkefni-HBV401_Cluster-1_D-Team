package Data;

import java.util.*;
import Objects.Booking;

import java.sql.*;


public class BookingDB {
    
    public void getBooking(int Booking_ID){

        try{

            Connection conn = DriverManager.getConnection("jdbc:sqlite:LokaverkefniDB.db");
            Statement statement = conn.createStatement();

            String query = "select name from tour";

            ResultSet result = statement.executeQuery(query);

            
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void getAllBookings(){

        try {

            String dbpath = "src/main/java/Data/LokaverkefniDB.db";
            
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbpath);
            System.out.println("Connection successful");
            
            Statement statement = conn.createStatement();

            String querry = "SELECT * FROM tour";

            ResultSet result = statement.executeQuery(querry);

            while(result.next()){
                System.out.println("tourID " + result.getInt("tourID"));
                System.out.println("Tour Name " + result.getString("tourName"));
            }

        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }


    }

    public void newBooking(){



    }

    public void updateBooking(){



    }

    public void removeBooking(){



    }


    
}
