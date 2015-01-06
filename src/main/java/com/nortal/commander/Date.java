package com.nortal.commander;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


/**
 * Created by karl on 7.12.2014.
 */
public class Date implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, d.MMMM yyyy, HH:mm");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    }
}
