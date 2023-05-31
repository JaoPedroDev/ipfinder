module com.ipfinder {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ipfinder to javafx.fxml;

    exports com.ipfinder;
}
