package hopur_h;
import java.util.Date;


public class Tour {
    
    private int Tour_ID;
    private int Admin_ID;
    private String TourName = null;
    private Date localDate = new Date();
    private double Price;
    private double Duration;
    private String Region;
    private int Available_seats;
    private String[] Catagory = new String[10];
    private String[] Language = new String[10];
    private String Description;

    // CONSTRUCTOR

    public Tour(int Admin_ID, String TourName, double Price, double Duration, String Region, int Available_seats, String[] Catagory, String[] Language){
        this.Admin_ID = Admin_ID;
        this.TourName = TourName;
        this.Price = Price;
        this.Duration = Duration;
        this.Region = Region;
        this.Available_seats = Available_seats;
        this.Catagory = Catagory;
        this.Language = Language;
    }

    //GETTERS______________________________________________________________________________________

    public int getAvailable_seats() {
        return Available_seats;
    }

    public String[] getCatagory() {
        return Catagory;
    }

    public String getDescription() {
        return Description;
    }

    public double getDuration() {
        return Duration;
    }

    public String[] getLanguage() {
        return Language;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public double getPrice() {
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

    public void setCatagory(String[] catagory) {
        Catagory = catagory;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    public void setLanguage(String[] language) {
        Language = language;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public void setPrice(double price) {
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
