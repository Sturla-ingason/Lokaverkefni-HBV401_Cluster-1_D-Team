package UI;

import java.io.IOException;
import javafx.fxml.FXML;

import Data.BookingDB;

public class PrimaryController {

    BookingDB test = new BookingDB();

    @FXML
    private void switchToSecondary() throws IOException {
        test.getAllBookings();
    }
}
