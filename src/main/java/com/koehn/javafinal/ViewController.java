package com.koehn.javafinal;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable
{

    @FXML
    private Text labelStartDate;

    @FXML
    private Text labelEndDate;

    @FXML
    private Label labelID;

    @FXML
    private Label label_class;

    @FXML
    private Label label_catalog;

    @FXML
    private Label label_location;

    @FXML
    private Label label_submissionTime;

    @FXML
    private Label label_peakTime;

    @FXML
    private Label label_beginTime;

    @FXML
    private Label label_endTime;

    @FXML
    private TextArea textarea_notes;

    @FXML
    private Hyperlink link;

    @FXML
    private ListView<String> listview_events;

    @FXML
    private ListView<String> listview_instruments;

    @FXML
    private ListView<FLR> list;

    private final ObservableList<FLR> content = FXCollections.observableList(FLRApplication.flr);

    private String url;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //cell factory definition
        list.setCellFactory(param -> new ListCell<FLR>()
        {
            @Override
            protected void updateItem(FLR flr, boolean empty)
            {
                super.updateItem(flr, empty);
                setText((empty || flr == null) ? "" : flr.toString());

            }
        });

        //selection listener definition
        list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends FLR> observable, FLR oldValue, FLR newValue) ->
        {
            labelID.setText(newValue.toString());
            label_class.setText(newValue.classType);
            label_catalog.setText(newValue.catalog);
            label_location.setText(newValue.sourceLocation);
            label_submissionTime.setText(newValue.submissionTime);
            label_peakTime.setText(newValue.peakTime);
            label_beginTime.setText(newValue.beginTime);
            label_endTime.setText(newValue.endTime);
            textarea_notes.setText(newValue.note);
            url = newValue.link;
            link.setText(newValue.link);

            if(newValue.linkedEvents != null)
            {
                List<FLR.linkedEvents> linkedEvents = List.of(newValue.linkedEvents);
                final ObservableList<FLR.linkedEvents> listview_events_OLS = FXCollections.observableList(linkedEvents);
                listview_events.getItems().setAll(String.valueOf(listview_events_OLS));
            }
            else
            {
                listview_events.getItems().clear();
            }

            if(newValue.instruments != null)
            {
                List<FLR.instruments> instruments = List.of(newValue.instruments);
                final ObservableList<FLR.instruments> instruments_events_OLS = FXCollections.observableList(instruments);
                listview_instruments.getItems().setAll(String.valueOf(instruments_events_OLS));
            }
            else
            {
                listview_instruments.getItems().clear();
            }
        });

        //add items to listview
        list.setItems(content);

        //select first cell by default
        list.getSelectionModel().select(0);

        //update navbar
        labelStartDate.setText(FLRApplication.StartDate);
        labelEndDate.setText(FLRApplication.EndDate);
    }

    @FXML
    protected void onBackButton() throws IOException
    {
        FLRApplication.changeScene("main.fxml");
    }

    @FXML
    protected void onChartButton() throws IOException
    {
        FLRApplication.changeScene("chart.fxml");
    }

    @FXML
    protected void onHyperlinkClicked()
    {
        FLRApplication.getHostService().showDocument(url);
    }
}