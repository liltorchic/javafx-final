//Alex Koehn | Final - option 3

/*
Create a Graphical application using Java FX that connects to any API (REST). You are welcome to use
any API of your choice to complete the work.
 */

package com.koehn.javafinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FLRApplication extends Application
{
    public static void main(String[] args)
    {
        launch();
    }

    //Static utility method to get host services
    private static FLRApplication applicationInstance;
    public static HostServices getHostService() {
        return applicationInstance.getHostServices();
    }

    public static Stage parentWindow;

    public static String StartDate;
    public static String EndDate;

    public static List<FLR> flr = List.of();

    //https://api.nasa.gov/
    static String apikey = "DEMO_KEY";

    public static boolean doApi = true;

    @Override
    public void start(Stage stage) throws IOException
    {
        FLRApplication.applicationInstance = this;
        parentWindow = stage;

        Scene root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));

        stage.setTitle("Alex Koehn DONKI Solar Flare");
        stage.setResizable(false);
        stage.setScene(root);
        stage.show();
    }

    public static void changeScene(String scenepath) throws IOException
    {
        Scene pane = FXMLLoader.load(Objects.requireNonNull(FLRApplication.class.getResource(scenepath)));
        
        if(scenepath.equals("main.fxml") || scenepath.equals("view.fxml"))
        {
            parentWindow.setResizable(false);
        }
        else if(scenepath.equals("chart.fxml"))
        {
            parentWindow.setResizable(true);
        }
        
        parentWindow.setScene(pane);
    }

    public static void setDateData(String start_date, String end_date)
    {
        StartDate = start_date;
        EndDate = end_date;
        System.out.println("Start: " + start_date + " ,End: " + end_date);
    }

    public static void doAPI(boolean _doAPI) throws URISyntaxException, IOException {
        StringBuilder inline = new StringBuilder();

        if (_doAPI)//testing flag
        {
            try
            {
                URL url = new URI(Data.build_url(StartDate,EndDate)).toURL();

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int response = conn.getResponseCode();

                if (response != 200)
                {
                    throw new RuntimeException("HttpResponseCode: " + response);
                }
                else// 200 - OK
                {
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext())
                    {
                        inline.append(scanner.nextLine());
                    }

                    //Close the scanner
                    scanner.close();

                    flr = new ObjectMapper().readValue(inline.toString(), new TypeReference<List<FLR>>() {});
                }
                changeScene("view.fxml");
            }
            catch (URISyntaxException | IOException e)
            {
                throw new RuntimeException(e);
            }

            //live api success
            System.out.println("Response from server with " + flr.size() + " solar flare records");
        }
        else //local testing
        {
            //use local sample response
            String json = Files.readString(
                    Path.of(Objects.requireNonNull(FLRApplication.class.getClassLoader()
                                    .getResource("sampleresponse.json")).toURI())
            );

            //parse data
            flr = new ObjectMapper().readValue(json, new TypeReference<List<FLR>>() {});

            //change scene
            changeScene("view.fxml");

        }


    }

}