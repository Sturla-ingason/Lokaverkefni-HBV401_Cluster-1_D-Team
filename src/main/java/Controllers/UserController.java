package Controllers;

import java.util.*;
import Data.UserDB;
import Objects.User;

public class UserController{

    private List<User> users = new ArrayList<>();
    private UserDB user_data = new UserDB();

    /*
     * Uppfærir listan af notendum sem við getum unnið með
     */
    public void updateUsers(List<User> new_users){
        this.users = new_users;
    }

    public void newUser(int userID, String name, String email, String Password, int adminID){

        User user = new User(userID, name, email, Password, adminID);
        user_data.newUser(user);
    }

    //TODO uppfærir notenda
    public void updateUser(){

    }

    //TODO Eyðir notenda
    public void deleateUser(){

    }

    //TODO leyfir notenda að skoða bókanirnar hjá sér
    public void veiwBookings(){

    }
    

}