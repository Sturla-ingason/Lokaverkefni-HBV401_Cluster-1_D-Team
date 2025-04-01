package testing;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import Controllers.SearchController;

import java.util.*;

import Objects.Tour;


public class SearchControllerTest {

    private Tour tourmock;
    private Tour tourmock2;
    private Tour tourmock3;
    private SearchController search = new SearchController();

    @Before
    public void setUp(){
        tourmock = mock(Tour.class);
        tourmock2 = mock(Tour.class);
        tourmock3 = mock(Tour.class);

        search = mock(SearchController.class);

        List<Tour> tours = new ArrayList<>();
        tours.add(tourmock);
        tours.add(tourmock2);
        tours.add(tourmock3);

        search.setTours(tours);
    }


    @Test
    public void TestStringSearch(){

        when(List<Tour> resault = search.stringSearch("paris"));



    }

}

