package com.koehn.javafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class ViewController
{
    @FXML
    private Text labelStartDate;

    @FXML
    private Text labelEndDate;

    @FXML
    private ListView list;

    @FXML
    protected void onBackButton() throws IOException
    {
        FLRApplication.changeScene("main.fxml");
    }




}