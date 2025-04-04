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
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Alex Koehn JavaFX Final!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate day1 = LocalDate.of(2022, 8, 23);
        LocalDate day2 = LocalDate.of(2022, 9, 23);
        String start_date = dtf.format(day1);
        String end_date = dtf.format(day2);

        StringBuilder inline = new StringBuilder();

        List<FLR> flr = List.of();

        try {

            URL url = new URI(Data.build_url(start_date,end_date)).toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {// if not response code ok
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {


                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }

                //Close the scanner
                scanner.close();

                flr = new ObjectMapper().readValue(inline.toString(), new TypeReference<List<FLR>>() {});

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(flr.toString());
        launch();
    }
}