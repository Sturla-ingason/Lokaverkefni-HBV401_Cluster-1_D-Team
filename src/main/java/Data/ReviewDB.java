package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import Objects.Review;

import java.sql.*;

public class ReviewDB {

    private String all_review_columns = "reviewID, rating, comment, userID, tourID";

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
    
    /*
     * Klassi sem leifir okkur að finna eitthvað review í databaseinu
     * returns review objecti.
     */
    public Review getReview(Review review){

        Review review_to_return = new Review(0, 0, null, 0, 0);

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_review_query = "SELECT * FROM review where reviewID = " + review.getReview_ID();

            ResultSet queryResult = statement.executeQuery(get_review_query);

            while(queryResult.next()){
                review_to_return.setReview_ID(queryResult.getInt("reviewID"));
                review_to_return.setRating(queryResult.getInt("rating"));
                review_to_return.setComment(queryResult.getString("comment"));
                review_to_return.setUser_ID(queryResult.getInt("userID"));
                review_to_return.setTour_ID(queryResult.getInt("tourID"));
            }

            return review_to_return;
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();

            return null;
        }

    }


    public List<Review> getAllReviews(){

        List<Review> reviews = new ArrayList<>();

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String get_all_query = "SELECT * FROM review";

            ResultSet all_reviews = statement.executeQuery(get_all_query);

            while(all_reviews.next()){
                Review tempReview = new Review(
                    all_reviews.getInt("reviewID"),
                    all_reviews.getInt("rating"),
                    all_reviews.getString("comment"),
                    all_reviews.getInt("userID"),
                    all_reviews.getInt("tourID")
                );

                reviews.add(tempReview);
            }

            return reviews;
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();

            return null;
        }

    }


    public void newReview(Review review){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String add_new_review_query = "INSERT INTO review(" + all_review_columns + ")" + 
            "VALUES ( " + review.getReview_ID() +","+
            review.getRating() +","+
            review.getComment() +","+
            review.getUser_ID() +","+
            review.getTour_ID();

            statement.executeQuery(add_new_review_query);
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();
        }

    }


    public void updateReview(Review review){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String update_review_query = "UPDATE review set(" + all_review_columns + ")" + 
            "VALUES ( " + review.getReview_ID() +","+
            review.getRating() +","+
            review.getComment() +","+
            review.getUser_ID() +","+
            review.getTour_ID() + "WHERE reviewID = " + review.getReview_ID();

            statement.executeQuery(update_review_query);
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();
        }

    }


    public void deletReview(Review review){

        try {

            Connection conn = getConnection();

            Statement statement = conn.createStatement();

            String delete_review_query = "DELETE FROM review WHERE reviewID = " + review.getReview_ID();

            statement.executeQuery(delete_review_query);
            
        } catch (SQLException e) {
            System.out.println("Connection faild");
            e.printStackTrace();
        }

    }
    
}
