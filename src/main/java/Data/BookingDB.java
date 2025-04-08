package Data;

import java.util.*;
import Objects.Booking;

import java.sql.*;


public class BookingDB {

    String all_columns_in_booking = "(bookingID, userID, tourID, date, numPeople, totalPrice)";

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
    
    public Booking getBooking(int Booking_ID){

        try{

            Booking booking = new Booking(0, 0, 0, null, 0, 0);

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_booking_query = "SELECT * FROM booking WHERE bookingID = " + Booking_ID;

            ResultSet booking_to_return = statement.executeQuery(get_booking_query);

            while(booking_to_return.next()){
                booking.setBooking_ID(booking_to_return.getInt("bookingID"));
                booking.setUser_ID(booking_to_return.getInt("userID"));
                booking.setTour_ID(booking_to_return.getInt("tourID"));
                booking.setLocalDate(booking_to_return.getString("date"));
                booking.setNumber_people(booking_to_return.getInt("numPeople"));
                booking.setToatl_price(booking_to_return.getInt("totalPrice"));
            }

            return booking;
            
        }catch(Exception e){
            e.printStackTrace();

            return null;
        }


    }

    public void getAllBookings(){

        try {
            List<Booking> bookings = new ArrayList<>();

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String all_bookings_query = "";

            ResultSet all_bookings = statement.executeQuery(all_bookings_query);

            while(all_bookings.next()){
                Booking tempBooking = new Booking(
                    all_bookings.getInt("bookingID"),
                    all_bookings.getInt("userID"),
                    all_bookings.getInt("tourID"),
                    all_bookings.getString("date"),
                    all_bookings.getInt("numPeople"),
                    all_bookings.getInt("totalPrice")
                );

                bookings.add(tempBooking);
            }

        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }


    }

    public void newBooking(Booking booking){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String new_booking_query = "INSERT INTO booking" + all_columns_in_booking +
            "Values(" + booking.getUser_ID() +","+
            booking.getUser_ID() +","+
            booking.getTour_ID() +","+
            booking.getLocalDate() +","+
            booking.getNumber_people() +","+
            booking.getToatl_price() + ")";

            statement.executeQuery(new_booking_query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateBooking(Booking booking){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String update_booking_query = "UPDATE booking set" + all_columns_in_booking +
            "Values(" + booking.getUser_ID() +","+
            booking.getUser_ID() +","+
            booking.getTour_ID() +","+
            booking.getLocalDate() +","+
            booking.getNumber_people() +","+
            booking.getToatl_price() + ")" + "WHERE bookingID = " + booking.getBooking_ID();

            statement.executeQuery(update_booking_query);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void removeBooking(Booking booking){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String remove_booking_query = "DELETE FROM booking WHERE bookingID = " + booking.getBooking_ID();
            
            statement.executeQuery(remove_booking_query);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    
}
