module com.example.autoluxe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.sql;
    requires org.jetbrains.annotations;
    requires itextpdf;

    opens com.example.autoluxe to javafx.fxml;
    exports com.example.autoluxe;
    exports ClasesObjetos;
    opens ClasesObjetos to javafx.fxml;
}