module com.ipfinder {
    requires transitive javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ipfinder to javafx.fxml;

    exports com.ipfinder;
}
