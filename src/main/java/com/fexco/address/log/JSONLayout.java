package com.fexco.address.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by diego.guimaraes on 05/08/16.
 */
public class JSONLayout extends Layout {

    public final SimpleDateFormat defaultDateFormat  = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.sss");
    private final ObjectMapper om = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
    private EnvironmentData envData = new EnvironmentData();

    @SuppressWarnings("rawtypes")
    public String format(LoggingEvent loggingEvent) {
        HashMap<String, Object> exceptionInformation = new HashMap<String, Object>();
        HashMap<String, Object> outputMap = new LinkedHashMap<String, Object>();
        Map mdc = loggingEvent.getProperties();

        outputMap.put("thread_name", loggingEvent.getThreadName());

        if (mdc != null) {
            Iterator it = mdc.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                outputMap.put((String)pairs.getKey(), pairs.getValue());
            }
        }

        outputMap.put("log_level", loggingEvent.getLevel().toString());
        outputMap.put("class", loggingEvent.getLocationInformation().getClassName());

        // Add environment info to log
        outputMap.put("environment", this.envData.getEnvironmentName() );
        outputMap.put("version", this.envData.getAppVersion());
        outputMap.put("application", this.envData.getAppName());

        if(!outputMap.containsKey("tid")) {
            outputMap.put("tid", LogHelper.getCurrentTID());
        }

        outputMap.put("date", dateFormat(loggingEvent.getTimeStamp()));
        outputMap.put("log_message", loggingEvent.getRenderedMessage());

        LocationInfo info = loggingEvent.getLocationInformation();
        outputMap.put("file", info.getFileName());
        outputMap.put("line_number", info.getLineNumber());
        outputMap.put("class", info.getClassName());
        outputMap.put("method", info.getMethodName());

        if (loggingEvent.getThrowableInformation() != null) {
            final ThrowableInformation throwableInformation = loggingEvent.getThrowableInformation();

            if (throwableInformation.getThrowable().getClass().getCanonicalName() != null) {
                exceptionInformation.put("exception_class", throwableInformation.getThrowable().getClass().getCanonicalName());
            }

            if (throwableInformation.getThrowable().getMessage() != null) {
                exceptionInformation.put("exception_message", throwableInformation.getThrowable().getMessage());
            }

            if (throwableInformation.getThrowableStrRep() != null) {
                String stackTrace = StringUtils.join(throwableInformation.getThrowableStrRep(), "\n");
                exceptionInformation.put("stacktrace", stackTrace);
            }

            outputMap.put("throwable", exceptionInformation);
        }

        try {
            return "#JSON# "+ om.writeValueAsString(outputMap)+"\n";
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    public String dateFormat(long timestamp) {
        return defaultDateFormat.format(timestamp);
    }

    @Override
    public void activateOptions() {

    }
}