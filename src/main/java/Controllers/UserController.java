package Controllers;

import java.util.*;
import Data.UserDB;
import Objects.User;
import Objects.Booking;

public class UserController{

    private List<User> users = new ArrayList<>();
    private UserDB user_data = new UserDB();

    /*
     * Uppfærir listan af notendum sem við getum unnið með
     */
    public void updateUsers(){
        users = user_data.getAllUsers();
    }

    public void newUser(int userID, String name, String email, String Password, int adminID){

        User user = new User(userID, name, email, Password, adminID);
        user_data.newUser(user);
    }

    //TODO uppfærir notenda
    public void updateUser(int userID, String name, String email, String Password, int adminID){

        User user = new User(userID, name, email, Password, adminID);
        user_data.updateUser(user);

    }

    //TODO Eyðir notenda
    public void deleateUser(int userID, String name, String email, String Password, int adminID){
        User user = new User(userID, name, email, Password, adminID);
        user_data.removeUser(user);

    }

    //TODO leyfir notenda að skoða bókanirnar hjá sér
    public List<Booking> veiwBookings(int userID){
        List<Booking> bookings = user_data.getUserBooking(userID);
        return bookings;
    }
    

}