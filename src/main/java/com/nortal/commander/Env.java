package com.nortal.commander;

import java.util.List;
import java.util.Map;

/**
 * Created by karl on 7.12.2014.
 */
public class Env implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        Map<String, String> keyValues = environment.getEnvVariables();
        for (String key : keyValues.keySet()) {
            String value = keyValues.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
