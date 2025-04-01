package Controllers;

import java.util.ArrayList;
import java.util.*;

import Data.ReviewDB;
import Objects.Review;


public class ReviewController{

    ReviewDB review_data = new ReviewDB();
    List<Review> Reviews = new ArrayList<>();

    public void addReview(){
        review_data.newReview();
    }

    public void editReview(){
        review_data.updateReview();
    }

    public void removeReview(){
        review_data.deletReview();
    }

}