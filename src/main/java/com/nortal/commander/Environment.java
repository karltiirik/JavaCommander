package com.nortal.commander;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by karl on 7.12.2014.
 */
public class Environment {
    private final long upTimeStart = DateTimeUtils.currentTimeMillis();
    private Map<String, String> envVariables = new HashMap<String, String>();


    public Map<String, String> getEnvVariables() {
        return envVariables;
    }

    public void setEnvVariables(Map<String, String> envVariables) {
        this.envVariables = envVariables;
    }

    public void addEnvVariable(String key, String value) {
        this.envVariables.put(key, value);
    }

    public String getEnvVariable(String key) {
        return envVariables.get(key);
    }

    public long getUpTimeStart() {
        return upTimeStart;
    }

    public String getCurrentDir(){
        return System.getProperty("user.dir");
    }

}
