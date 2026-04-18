package com.koehn.javafinal;

import java.time.format.DateTimeFormatter;

import static com.koehn.javafinal.FLRApplication.apikey;

public class Data
{

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String build_url(String start, String end)
    {
        return "https://api.nasa.gov/DONKI/FLR?startDate=" + start + "&endDate=" + end + "&api_key=" + apikey;
    }

}


