package Data;

import java.util.*;
import Objects.Booking;

import java.sql.*;


public class BookingDB {
    
    public void getBooking(){

        try{

            Connection conn = DriverManager.getConnection(null, null, null);
            Statement statement = conn.createStatement();

            String query = "select name from tour";

            ResultSet result = statement.executeQuery(query);

            
        }catch(Exception e){

        }


    }

    public void getAllBookings(){



    }

    public void newBooking(){



    }

    public void updateBooking(){



    }

    public void removeBooking(){



    }
    
}
