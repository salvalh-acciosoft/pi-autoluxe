module com.example.autoluxe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.autoluxe to javafx.fxml;
    exports com.example.autoluxe;
}