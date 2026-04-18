//https://ccmc.gsfc.nasa.gov/tools/DONKI/#donki-webservice-calls-api
package com.koehn.javafinal;

import java.util.List;

public class FLR
{
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
    public sentNotifications[] sentNotifications;

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

    public static class sentNotifications
    {
        public String messageID;
        public String messageIssueTime;
        public String messageURL;

        @Override
        public String toString()
        {
            return "ID: " + messageID + " Time: " + messageIssueTime + " URL: " + messageURL;
        }
    }

    @Override
    public String toString()
    {
        return flrID;
    }

}