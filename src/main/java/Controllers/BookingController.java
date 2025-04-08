package Controllers;

import java.util.*;
import Data.BookingDB;
import Objects.Booking;


public class BookingController {
    
    private BookingDB booking_data = new BookingDB();
    private List<Booking> bookings = new ArrayList<>();

    public void updateBookings(){
        this.bookings = booking_data.getAllBookings();
    }


    public void addBooking(int bookingID, int userID, int tourID, String date, int numPeople, int totalPrice){

        Booking booking = new Booking(bookingID, userID, tourID, date, numPeople, totalPrice);

        booking_data.newBooking(booking);

    }


    public void removeBooking(int bookingID, int userID, int tourID, String date, int numPeople, int totalPrice){

        Booking booking = new Booking(bookingID, userID, tourID, date, numPeople, totalPrice);

        booking_data.removeBooking(booking);

    }


    public void updateBooking(int bookingID, int userID, int tourID, String date, int numPeople, int totalPrice){

        Booking booking = new Booking(bookingID, userID, tourID, date, numPeople, totalPrice);

        booking_data.updateBooking(booking);

    }


    public List<Booking> getUserBooking(int userID){
        List<Booking> userBookings = new ArrayList<>();

        for(Booking booking: bookings){
            if(booking.getUser_ID() == userID){
                userBookings.add(booking);
            }
        }

        return userBookings;

    }


}
