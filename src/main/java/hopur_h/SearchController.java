package hopur_h;

public class SearchController {
    
    public Tour[] stringSearch(String querry){
        Tour[] tour = new Tour[10];

        // Tekur inn leitar orð

        // Kallar á tour db til að finna Tour í databaseinu sem passa við strengin

        // Skilar fylki af öllum tours sem innihalda strengin í nafninu

        return tour;
    }


    public Tour[] priceSearch(double min, double max){

        Tour[] tour = new Tour[10];

        // Tekur inn tvær tölur min og max

        // kallar á aðferð í TourDB til að querrya data baseið til að finna alla þá
        // Tours sem eru með verð á milli min og max

        //Skilar lista af tours sem uppfylla skilirðinn.


        return tour;

    }

    public Tour[] dateSearch(){
        Tour[] tour = new Tour[10];

        // Tekur inn tvær breytur. date_form og date_too

        // Kallar á aðferð í TourDB til að finna alla þá tours sem eru á milli data_from og date_too

        // Skilar lista af öllum þeim tours sem uppfylla skilirðinn

        return tour;
    }


    public Tour[] regionSearch(String region){
        Tour[] tour = new Tour[10];

        // Tekur in eina breytur region

        // kallar á aðferð í TourDB sem querryar data basið eftir því hvaða ferðir eru í regioninnu
        
        // Skilar lista af öllum þeim tours sem uppfyllakröfurnar.

        return tour;
    }

}
