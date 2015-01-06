package com.nortal.commander;

import org.apache.commons.io.FileUtils;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;
import java.util.List;

/**
 * Created by karl on 16.12.2014.
 */
public class Cat implements Command {
    @Override
    public void execute(List<String> arguments, Environment environment) {
        if (!arguments.isEmpty()) {
            for (String arg : arguments){
                String encoding = getEncoding(arg);
                File file = new File(arg);
                try {
                    List lines = FileUtils.readLines(file, encoding);
                    for (Object line : lines){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    String newLine = System.getProperty("line.separator");
                    System.out.printf("cat: can't open '%s': No such file or directory%s", arg,newLine);
                }
            }
        }
    }

    public String getEncoding(String file){
        byte[] buf = new byte[4096];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        UniversalDetector detector = new UniversalDetector(null);
        int nread;
        try {
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();

        if (encoding != null) {
            return encoding;
        } else {
            return "UTF-8";
        }
    }
}
