package Objects;
public class User {
    
    private int User_ID;
    private String Name;
    private String Email;
    private String Password;
    private int Admin;
    private Booking[] Bookings = new Booking[10];

    //TODO make constructer for user

    public User(int User_ID, String Name, String Email, String Password, int Admin){
        this.User_ID = User_ID;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Admin = Admin;
    }

    //GETTERS_____________________________________________________________________________________

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public Booking[] getBookings() {
        return Bookings;
    }
    
    public int getAdmin() {
        return Admin;
    }

    //SETTERS____________________________________________________________________________________

    public void setAdmin(int admin) {
        Admin = admin;
    }

    public void setBookings(Booking[] bookings) {
        Bookings = bookings;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

}
