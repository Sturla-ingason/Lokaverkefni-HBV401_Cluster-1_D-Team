package Objects;


import java.util.Date;

public class Booking {
    
    private int Booking_ID;
    private int User_ID;
    private int Tour_ID;
    private String localDate;
    private int number_people;
    private int toatl_price;

    //TODO make constructor for Booking

    public Booking(int Booking_ID, int User_ID, int Tour_ID, String localDate, int number_people, int toatl_price){
        this.Booking_ID = Booking_ID;
        this.User_ID = User_ID;
        this.Tour_ID = Tour_ID;
        this.localDate = localDate;
        this.number_people = number_people;
        this.toatl_price = toatl_price;
    }

    //GETTERS---------------------------------------------------------------------------

    public int getBooking_ID() {
        return Booking_ID;
    }

    public String getLocalDate() {
        return localDate;
    }

    public int getNumber_people() {
        return number_people;
    }

    public int getToatl_price() {
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

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setNumber_people(int number_people) {
        this.number_people = number_people;
    }

    public void setToatl_price(int toatl_price) {
        this.toatl_price = toatl_price;
    }

    public void setTour_ID(int tour_ID) {
        Tour_ID = tour_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

}
