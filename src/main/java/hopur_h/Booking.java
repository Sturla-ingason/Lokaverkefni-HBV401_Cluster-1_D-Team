package hopur_h.objects;

import java.util.Date;

public class Booking {
    
    private int Booking_ID;
    private int User_ID;
    private int Tour_ID;
    private Date localDate = new Date();
    private int number_people;
    private double toatl_price;

    //GETTERS---------------------------------------------------------------------------

    public int getBooking_ID() {
        return Booking_ID;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public int getNumber_people() {
        return number_people;
    }

    public double getToatl_price() {
        return toatl_price;
    }

    public int getTour_ID() {
        return Tour_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    //SETTERS--------------------------------------------------------------------------

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public void setNumber_people(int number_people) {
        this.number_people = number_people;
    }

    public void setToatl_price(double toatl_price) {
        this.toatl_price = toatl_price;
    }

    public void setTour_ID(int tour_ID) {
        Tour_ID = tour_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

}
