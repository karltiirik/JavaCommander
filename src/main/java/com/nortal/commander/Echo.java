package com.nortal.commander;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by karl on 7.12.2014.
 */
public class Echo implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        if (arguments.contains(">")){
            Integer index = arguments.indexOf(">");
            List<String> text = arguments.subList(0, index);
            File file = new File(arguments.get(index+1));
            writeToFile(file,text);
        } else {
            printText(arguments,environment);
        }
    }
    private void writeToFile(File file, List<String> text){
        try {
            file.createNewFile();
            FileUtils.writeLines(file,text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printText(List<String> arguments, Environment environment){
        replaceVariables(arguments, environment);
        for (String arg : arguments) {
            System.out.print(arg + " ");
        }
        System.out.println("");
    }
    private void replaceVariables(List<String> arguments, Environment environment){
        for (String arg : arguments) {
            if (arg.startsWith("$")) {
                String key = arg.substring(1);
                String value = environment.getEnvVariable(key);
                Integer index = arguments.indexOf(arg);
                arguments.set(index,value);
            }
        }

    }
}
