package com.fexco.address.log;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by diego.guimaraes on 05/08/16.
 */
public class LogHelper {

    private static ThreadLocal<String> currentTID = new ThreadLocal();

    public static void setCurrentTID(String tid) {
        currentTID.set(tid);
    }

    public static String getCurrentTID() {
        return StringUtils.isNotBlank(currentTID.get()) ? currentTID.get(): UUID.randomUUID().toString();
    }
}
