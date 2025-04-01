module hopur_h {
    requires javafx.controls;
    requires javafx.fxml;

    opens hopur_h to javafx.fxml, mockito;
    exports hopur_h;
}
