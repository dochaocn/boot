package com.bsb.rps.manager;

public class ProcessDateManager {

    private static String processDate;

    public static String getProcessDate() {
        return processDate;
    }

    public synchronized static void setProcessDate(String processDate) {
        ProcessDateManager.processDate = processDate;
    }

}
