package com.koehn.javafinal;

public class Data
{
    public static String api_key = KEY.API_KEY;

    public static String build_url(String start, String end)
    {
        return "https://api.nasa.gov/DONKI/FLR?startDate=" + start + "&endDate=" + end + "&api_key=" + api_key;
    }
}


