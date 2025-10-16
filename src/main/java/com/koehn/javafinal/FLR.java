//https://ccmc.gsfc.nasa.gov/tools/DONKI/#donki-webservice-calls-api
package com.koehn.javafinal;

public class FLR
{
    //todo: fix for new api
    public String sentNotifications;
    public String flrID;
    public String catalog;
    public instruments[] instruments;
    public String beginTime;
    public String peakTime;
    public String endTime;
    public String classType;
    public String sourceLocation;//
    public int activeRegionNum;
    public String note;
    public String submissionTime;
    public int versionId;
    public String link;
    public linkedEvents[] linkedEvents;

    public static class instruments
    {
        public String displayName;

        @Override
        public String toString()
        {
            return displayName;
        }
    }
 
    public static class linkedEvents
    {
        public String activityID;

        @Override
        public String toString()
        {
            return activityID;
        }
    }

    @Override
    public String toString()
    {
        return flrID;
    }

}