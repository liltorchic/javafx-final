package com.koehn.javafinal;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ChartController implements Initializable
{
    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        final CategoryAxis timestamp_axis = new CategoryAxis();
        timestamp_axis.setLabel("Timestamp");

        final CategoryAxis timestamp_class = new CategoryAxis();
        timestamp_class.setLabel("Class");

        //Defining the chart
        final LineChart<String,String> lineChart = new LineChart<>(timestamp_axis, timestamp_class);

        //Defining series
        XYChart.Series<String, String> series = new XYChart.Series<>();
        series.setName("Intensity");

        //Defining hash set for ordered class axis
        Set<String> classSet = new HashSet<>();


        for (FLR element : FLRApplication.flr)
        {
            //add list data to series
            series.getData().add(new XYChart.Data<>(element.peakTime, element.classType));
            //update hash with class found in list
            classSet.add(element.classType);
        }

        //convert hash to list
        List<String> sortedClasses = new ArrayList<>(classSet);
        //sort class list
        sortedClasses.sort(Comparator.comparingDouble(this::getFlareStrength));
        //set axis categories from sorted class list
        timestamp_class.setCategories(FXCollections.observableArrayList(sortedClasses));

        //add chart data from series
        lineChart.getData().add(series);

        //add chart to vbox with jfx scene
        vbox.getChildren().add(lineChart);
    }


    @FXML
    protected void onButtonPressed() throws IOException
    {
        FLRApplication.changeScene("view.fxml");
    }

    //calculates double value used to compare flare strength
    private double getFlareStrength(String flareClass)
    {
        char category = flareClass.charAt(0);
        double multiplier = switch (category) {
            case 'A' -> 1;
            case 'B' -> 10;
            case 'C' -> 100;
            case 'M' -> 1000;
            case 'X' -> 10000;
            default -> 0;
        };
        double value = Double.parseDouble(flareClass.substring(1));
        return multiplier * value;
    }

}