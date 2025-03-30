package hopur_h;
import java.util.*;

public class SearchController {

    TourDB tourDB = new TourDB();
    List<Tour> tours = new ArrayList<>();

    // uppfærum tours listan okkar ef við uppfærum einhverja tours
    public void updateTours(){
        tours = tourDB.getAllTours();
    }
    
    /*
     * Searches all the tours in tha data base and checks if they match the query string
     * @param query = the string to search for
     * @return a list of all the matching tours
     */
    public List<Tour> stringSearch(String query){
        List<Tour> matchingTours = new ArrayList<>();

        for(Tour tour : tours){
            if(tour.getTourName().toLowerCase().contains(query.toLowerCase())){
                matchingTours.add(tour);
            }
        }

        return matchingTours;
    }


    /*
     * Searches all the tours in the data base 
     */
    public List<Tour> priceSearch(double min, double max){

        List<Tour> matchingTours = new ArrayList<>();

        for(Tour tour: tours){
            if(tour.getPrice() < max && tour.getPrice() > min){
                matchingTours.add(tour);
            }
        }

        return matchingTours;

    }


    public Tour[] dateSearch(){
        Tour[] tour = new Tour[10];

        // Tekur inn tvær breytur. date_form og date_too

        // Kallar á aðferð í TourDB til að finna alla þá tours sem eru á milli data_from og date_too

        // Skilar lista af öllum þeim tours sem uppfylla skilirðinn

        return tour;
    }


    public List<Tour> regionSearch(String region){
        List<Tour> matchingTours = new ArrayList<>();
    
        for(Tour tour : tours){
            if(tour.getRegion().toLowerCase().contains(region.toLowerCase())){
                matchingTours.add(tour);
            }
        }

        return matchingTours;
    }

}
