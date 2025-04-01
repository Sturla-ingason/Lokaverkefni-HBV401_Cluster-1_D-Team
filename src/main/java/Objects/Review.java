package Objects;


public class Review {

    private int Review_ID;
    private int rating;
    private String comment;
    private int User_ID;
    private int Tour_ID;

    //GETTERS___________________________________________________________________________________

    public String getComment() {
        return comment;
    }
    
    public int getRating() {
        return rating;
    }

    public int getReview_ID() {
        return Review_ID;
    }

    public int getTour_ID() {
        return Tour_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    //SETTERS_________________________________________________________________________________

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview_ID(int review_ID) {
        Review_ID = review_ID;
    }

    public void setTour_ID(int tour_ID) {
        Tour_ID = tour_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    
}
