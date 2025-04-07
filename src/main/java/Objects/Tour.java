package Objects;

import java.util.Date;


public class Tour {
    
    private int Tour_ID;
    private int Admin_ID;
    private String TourName = null;
    private String localDate;
    private int Price;
    private int Duration;
    private String Region;
    private int Available_seats;
    private String Catagory;
    private String Language;
    private String Description;

    // CONSTRUCTOR

    public Tour(int Tour_ID, int Admin_ID, String TourName, String localDate, int Price, int Duration, String Region, int Available_seats, String Catagory, String Language, String Description){
        this.Tour_ID = Tour_ID;
        this.Admin_ID = Admin_ID;
        this.TourName = TourName;
        this.localDate = localDate;
        this.Price = Price;
        this.Duration = Duration;
        this.Region = Region;
        this.Available_seats = Available_seats;
        this.Catagory = Catagory;
        this.Language = Language;
        this.Description = Description;
    }

    //GETTERS______________________________________________________________________________________

    public int getAvailable_seats() {
        return Available_seats;
    }

    public String getCatagory() {
        return Catagory;
    }

    public String getDescription() {
        return Description;
    }

    public double getDuration() {
        return Duration;
    }

    public String getLanguage() {
        return Language;
    }

    public String getLocalDate() {
        return localDate;
    }

    public int getPrice() {
        return Price;
    }

    public String getRegion() {
        return Region;
    }

    public String getTourName() {
        return TourName;
    }

    public int getTour_ID() {
        return Tour_ID;
    }

    public int getAdmin_ID() {
        return Admin_ID;
    }

    // SETERS_____________________________________________________________________________________

    public void setAvailable_seats(int available_seats) {
        Available_seats = available_seats;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public void setTourName(String tourName) {
        TourName = tourName;
    }

    public void setTour_ID(int tour_ID) {
        Tour_ID = tour_ID;
    }

    public void setAdmin_ID(int admin_ID) {
        Admin_ID = admin_ID;
    }
    

}
