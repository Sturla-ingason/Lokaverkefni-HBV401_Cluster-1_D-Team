package Data;

import java.util.*;

import Objects.Booking;
import Objects.User;

import java.sql.*;

public class UserDB {

    private String column_names_in_user_table = "userID, name, email, password, adminID, bookings";

    /*
     * Establishes a connection with the data base
     * returns a connection with the database
     */
    public Connection getConnection(){

        try {
            String dblocation = "src/main/java/Data/LokaverkefniDB.db";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dblocation);
            System.out.println("Connection Successful");

            return conn;

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();

            return null;
        }

    }
    
    public User getUser(User user_to_get){
        User user_to_return = new User(0, null, null, null, 0);

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_User_querry = "SELECT * FROM user where userID = " + user_to_get.getUser_ID();

            ResultSet resultSet = statement.executeQuery(get_User_querry);

            while(resultSet.next()){
                user_to_return.setUser_ID(resultSet.getInt("userID"));
                user_to_return.setName(resultSet.getString("name"));
                user_to_return.setEmail(resultSet.getString("email"));
                user_to_return.setPassword(resultSet.getString("password"));
                user_to_return.setAdmin(resultSet.getInt("adminID"));
                //! need to add bookings here so the user can see them
            }

            return user_to_return;
            
        } catch (SQLException e) {
            System.out.println("Connectio failed");
            e.printStackTrace();

            return null;
        }


    }

    /*
     * Method that gets all the users from the data base
     * returns a list of all users in the data base
     */
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_all_users_querry = "SELECT * FROM user";

            ResultSet all_users = statement.executeQuery(get_all_users_querry);

            while(all_users.next()){
                User tempUser = new User(
                    all_users.getInt("userID"), 
                    all_users.getString("name"), 
                    all_users.getString("email"),
                    all_users.getString("password"),
                    all_users.getInt("adminID")
                    //! NEED TO ADD BOOKINGS HERE
                );
                
                users.add(tempUser);
            }

            return users;
            
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();

            return null;
        }


    }

    /*
     * method that allows us to add a new user to the data base
     * takes 
     */
    public void newUser(User user){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String new_user_querry = "INSERT INTO user(" + column_names_in_user_table + ")" +
            "Values" + user.getUser_ID() +","+ user.getName() +","+ user.getEmail() +","+ user.getPassword() +","+ user.getAdmin() +","+ user.getBookings();

            statement.executeQuery(new_user_querry);
            
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }

    public void updateUser(User user){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String update_user_querry = "UPDATE user set (" + column_names_in_user_table + ") Values( " +
            user.getUser_ID() +","+
            user.getName() +","+
            user.getEmail() +","+
            user.getPassword() +","+
            user.getAdmin() +","+
            user.getBookings() + ")";

            statement.executeQuery(update_user_querry);
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();
        }

    }

    public void removeUser(User user){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String delete_user_querry = "DELETE FROM user WHERE userID = " + user.getUser_ID();

            statement.executeQuery(delete_user_querry);
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();
        }

    }

    public List<Booking> getUserBooking(int userID){

        try {

            List<Booking> user_bookings = new ArrayList<>();

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_user_booking_query = "SELECT * FROM booking where userID = " + userID;

            ResultSet query_result = statement.executeQuery(get_user_booking_query);

            while(query_result.next()){
                Booking tempBooking = new Booking(
                query_result.getInt("bookingID"),
                query_result.getInt("userID"),
                query_result.getInt("tourID"),
                query_result.getString("date"),
                query_result.getInt("numPeople"),
                query_result.getInt("totalPrice")
                );

                user_bookings.add(tempBooking);
                
            }

            return user_bookings;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    
}
