package Controllers;

import java.util.ArrayList;
import java.util.*;

import Data.ReviewDB;
import Objects.Review;


public class ReviewController{

    ReviewDB review_data = new ReviewDB();
    List<Review> Reviews = new ArrayList<>();

    public void addReview(){
        Review review = new Review(0, 0,null, 0, 0);

        review_data.newReview(review);
    }

    public void editReview(){

        Review review = new Review(0, 0,null, 0, 0);
        review_data.updateReview(review);
    }

    public void removeReview(){
        Review review = new Review(0, 0,null, 0, 0);
        review_data.deletReview(review);
    }

}