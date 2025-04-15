module com.koehn.javafxfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jackson.core;
    requires jackson.databind;

    opens com.koehn.javafinal to javafx.fxml;
    exports com.koehn.javafinal;
}