package com.koehn.javafinal;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class MainController
{

    @FXML
    private DatePicker dateBegin;

    @FXML
    private DatePicker dateEnd;

    @FXML
    protected void onSearched()
    {
        //check if date is filled in
        if(dateBegin.getValue() != null || dateEnd.getValue() != null)
        {
            LocalDate day1 = dateBegin.getValue();
            LocalDate day2 = dateEnd.getValue();

            //check if date entered makes sense
            if(day1.isBefore(day2))
            {
                String start_date = Data.dtf.format(day1);
                String end_date = Data.dtf.format(day2);

                FLRApplication.setDateData(start_date, end_date);
                FLRApplication.doAPI(true);
            }

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