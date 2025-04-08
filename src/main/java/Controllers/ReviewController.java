package Controllers;

import java.util.ArrayList;
import java.util.*;

import Data.ReviewDB;
import Objects.Review;


public class ReviewController{

    ReviewDB review_data = new ReviewDB();
    List<Review> Reviews = new ArrayList<>();

    public void updateReviewList(){
        Reviews = review_data.getAllReviews();
    }

    public void addReview(int reviewID, int ratin, String comment, int userID, int tourID){
        Review review = new Review(reviewID, ratin, comment, userID, tourID);

        review_data.newReview(review);
    }

    public void editReview(int reviewID, int ratin, String comment, int userID, int tourID){

        Review review = new Review(reviewID, ratin, comment, userID, tourID);
        review_data.updateReview(review);
    }

    public void removeReview(int reviewID, int ratin, String comment, int userID, int tourID){
        Review review = new Review(reviewID, ratin, comment, userID, tourID);
        review_data.deletReview(review);
    }

    public List<Review> getUserReviews(int userID){
        List<Review> userReview = new ArrayList<>();
        
        for(Review review: Reviews){
            
            if( review.getUser_ID() == userID){
                userReview.add(review);
            }
        }

        return userReview;

    }

}