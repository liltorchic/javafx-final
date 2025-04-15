package com.koehn.javafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController
{
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    private DatePicker dateBegin;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private ProgressIndicator spinner;//lol this doesnt work without threading

    @FXML
    protected void onSearched()
    {
        if(dateBegin.getValue() != null || dateEnd.getValue() != null)
        {
            spinner.setVisible(true);
            LocalDate day1 = dateBegin.getValue();
            LocalDate day2 = dateEnd.getValue();
            String start_date = dtf.format(day1);
            String end_date = dtf.format(day2);
            FLRApplication.getDateData(start_date, end_date);
            FLRApplication.doAPI(true);
        }
    }

    @FXML
    protected void onHyperlinkNasaClicked()
    {
        FLRApplication.getHostService().showDocument("https://kauai.ccmc.gsfc.nasa.gov/DONKI/");
    }

    @FXML
    protected void onHyperlinkAlexClicked()
    {
        FLRApplication.getHostService().showDocument("https://alexoliviakoehn.com");
    }
}