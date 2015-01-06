package com.nortal.commander;

import java.util.List;

/**
 * Created by karl on 7.12.2014.
 */
public class Export implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        for (String arg : arguments) {
            String[] keyValue = arg.split("=");
            environment.addEnvVariable(keyValue[0], keyValue[1]);
        }
    }
}
