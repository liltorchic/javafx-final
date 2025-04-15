package com.koehn.javafinal;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController
{
    @FXML
    private Button buttonSearch;

    @FXML
    private DatePicker dateBegin;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private Hyperlink linkNasa;

    @FXML
    private Hyperlink linkAlex;

    @FXML
    private ImageView splashImg;

    @FXML
    protected void onSearched(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate day1 = dateBegin.getValue();
        LocalDate day2 = dateEnd.getValue();
        String start_date = dtf.format(day1);
        String end_date = dtf.format(day2);
        HelloApplication.getDateData(start_date, end_date);
    }
}