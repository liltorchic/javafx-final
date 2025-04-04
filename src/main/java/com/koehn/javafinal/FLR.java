package com.koehn.javafinal;

public class FLR {

    public String flrID;
    public String catalog;
    public instruments[] instruments;
    public String beginTime;
    public String peakTime;
    public String endTime;
    public String classType;
    public String sourceLocation;
    public int activeRegionNum;
    public String note;
    public String submissionTime;
    public int versionId;
    public String link;
    public linkedEvents[] linkedEvents;

    public static class instruments{
        public String displayName;
    }
 
    public static class linkedEvents{
        public String activityID;

    }

}


