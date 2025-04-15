//Alex Koehn | Final - option 3

/*
Create a Graphical application using Java FX that connects to any API (REST). You are welcome to use
any API of your choice to complete the work.
 */

package com.koehn.javafinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HelloApplication extends Application
{
    public static Stage parentWindow;

    private static String StartDate, EndDate;

    @Override
    public void start(Stage stage) throws IOException
    {
        parentWindow = stage;

        Scene root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));

        stage.setTitle("Alex Koehn JavaFX Final!");
        stage.setScene(root);
        stage.show();
    }

    public static void main(String[] args)
    {
        boolean doApi = false;

        StringBuilder inline = new StringBuilder();

        List<FLR> flr = List.of();

        if (doApi) {
            try
            {

                URL url = new URI(Data.build_url(StartDate,EndDate)).toURL();

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int responsecode = conn.getResponseCode();

                if (responsecode != 200)
                {
                    // if not response code ok
                    throw new RuntimeException("HttpResponseCode: " + responsecode);
                }
                else
                {
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext())
                    {
                        inline.append(scanner.nextLine());
                    }

                    //Close the scanner
                    scanner.close();

                    flr = new ObjectMapper().readValue(inline.toString(), new TypeReference<>() {});
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Response from server with " + flr.size() + " solar flair records");
        launch();
    }

    public static void getDateData(String start_date, String end_date)
    {
        StartDate = start_date;
        EndDate = end_date;
        System.out.println("Start: " + start_date);
    }
}