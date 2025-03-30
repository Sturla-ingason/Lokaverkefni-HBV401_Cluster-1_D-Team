package hopur_h;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SearchControllerTest {

    private SearchController searchController;
    private TourDB mockTourDB;
    private List<Tour> mockTours;

    @BeforeEach
    public void setUp() {
        // Create mock of TourDB
        mockTourDB = mock(TourDB.class);
        
        // Initialize the SearchController with the mockTourDB
        searchController = new SearchController();
        searchController.tourDB = mockTourDB;

        // Create mock data
        mockTours = new ArrayList<>();
        Tour tour1 = new Tour("Paris Adventure");
        Tour tour2 = new Tour("New York City Tour");
        Tour tour3 = new Tour("Amazing Tokyo Tour");

        mockTours.add(tour1);
        mockTours.add(tour2);
        mockTours.add(tour3);

        // Define behavior of the mocked TourDB (getAllTours)
        when(mockTourDB.getAllTours()).thenReturn(mockTours);

        // Simulate calling updateTours to populate the tours list
        searchController.updateTours();
    }

    @Test
    public void testStringSearch_MatchFound() {
        // Test the stringSearch method with query "Paris"
        List<Tour> result = searchController.stringSearch("Paris");

        // Verify that the result contains only "Paris Adventure"
        assertEquals(1, result.size());
        assertEquals("Paris Adventure", result.get(0).getTourName());
    }

    @Test
    public void testStringSearch_MultipleMatches() {
        // Test the stringSearch method with query "Tour"
        List<Tour> result = searchController.stringSearch("Tour");

        // Verify that the result contains two matching tours
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(t -> t.getTourName().equals("New York City Tour")));
        assertTrue(result.stream().anyMatch(t -> t.getTourName().equals("Amazing Tokyo Tour")));
    }

    @Test
    public void testStringSearch_NoMatch() {
        // Test the stringSearch method with a query that has no matches
        List<Tour> result = searchController.stringSearch("London");

        // Verify that no tours match the query
        assertEquals(0, result.size());
    }
}


