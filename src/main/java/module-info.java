module com.koehn.javafinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.koehn.javafinal to javafx.fxml;
    exports com.koehn.javafinal;
}