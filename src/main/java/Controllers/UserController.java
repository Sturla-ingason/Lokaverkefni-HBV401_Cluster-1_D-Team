package Controllers;

import java.util.*;
import Data.UserDB;
import Objects.User;

public class UserController{

    private List<User> users = new ArrayList<>();
    private UserDB user_data = new UserDB();

    public void updateUsers(List<User> new_users){
        users = new_users;
    }

    public void newUser(int userID, String name, String email, String Password, int adminID, String Bookings){
        user_data.newUser(userID, name, email, Password, adminID, Bookings);
    }
    

}