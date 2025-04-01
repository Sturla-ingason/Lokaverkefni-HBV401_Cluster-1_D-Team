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
    private SearchController search;

    @Before
    public void setUp(){
        tourmock = mock(Tour.class);
        tourmock2 = mock(Tour.class);
        tourmock3 = mock(Tour.class);

        when(tourmock.getTourName()).thenReturn("Day tour in paris");
        when(tourmock2.getTourName()).thenReturn("two day sight seeing in England");
        when(tourmock3.getTourName()).thenReturn("Museium tour in sweeden");

        search = new SearchController();
        search.setTours(Arrays.asList(tourmock,tourmock2,tourmock3));

    }


    @Test
    public void TestStringSearch(){

        List<Tour> resault = search.stringSearch("paris");

        System.out.println(resault);

        assertEquals(1, resault.size());
        assertTrue(resault.contains(tourmock));

    }

    @Test
    public void TestIfNotMatch(){

        List<Tour> resault = search.stringSearch("Poland");

        assertEquals(0, resault.size());

    }

    @Test
    public void TestIfQuerryEmpty(){
        List<Tour> resault = search.stringSearch("");

        assertEquals(0, resault.size());
    }

}

