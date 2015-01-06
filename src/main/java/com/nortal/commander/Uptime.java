package com.nortal.commander;

import org.joda.time.DateTimeUtils;
import org.joda.time.Period;
import java.util.List;

/**
 * Created by karl on 7.12.2014.
 */
public class Uptime implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        Period upTime = new Period(environment.getUpTimeStart(), DateTimeUtils.currentTimeMillis());
        String time = String.format("%02dh %02dm %02ds", upTime.getHours(), upTime.getMinutes(), upTime.getSeconds());
        System.out.println(time);
    }
}
