package com.koehn.javafinal;

import java.time.format.DateTimeFormatter;

public class Data
{
    private static final String api_key = KEY.API_KEY;

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String build_url(String start, String end)
    {
        return "https://api.nasa.gov/DONKI/FLR?startDate=" + start + "&endDate=" + end + "&api_key=" + api_key;
    }

}


