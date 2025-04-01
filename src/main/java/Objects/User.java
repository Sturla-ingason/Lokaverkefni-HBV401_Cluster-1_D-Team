package Objects;
public class User {
    
    private int User_ID;
    private String Name;
    private String Email;
    private String Password;
    private boolean Admin;
    private Booking[] Bookings = new Booking[10];

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

    //SETTERS____________________________________________________________________________________

    public void setAdmin(boolean admin) {
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
