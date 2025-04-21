package com.koehn.javafinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    private DatePicker dateBegin;

    @FXML
    private DatePicker dateEnd;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //cell factory definition
        dateBegin.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        //cell factory definition
        dateEnd.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        //set default end date to current date
        dateEnd.setValue(LocalDate.now());
    }

    @FXML
    protected void onSearched()
    {
        //check if dates are selected
        if(dateBegin.getValue() != null || dateEnd.getValue() != null)
        {
            LocalDate day1 = dateBegin.getValue();
            LocalDate day2 = dateEnd.getValue();

            //check if date entered makes logical sense
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