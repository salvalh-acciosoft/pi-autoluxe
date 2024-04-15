module com.example.autoluxe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.autoluxe to javafx.fxml;
    exports com.example.autoluxe;
}