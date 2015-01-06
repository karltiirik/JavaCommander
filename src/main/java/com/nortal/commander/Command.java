package com.nortal.commander;

import java.util.List;

/**
 * Created by karl on 7.12.2014.
 */
public interface Command {
    void execute(List<String> arguments, Environment environment);
}
