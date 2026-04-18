module com.koehn.javafxfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires java.desktop;
    requires java.sql;

    opens com.koehn.javafinal to javafx.fxml;
    exports com.koehn.javafinal;
    exports com.koehn.javafinal.controller;
    opens com.koehn.javafinal.controller to javafx.fxml;
}