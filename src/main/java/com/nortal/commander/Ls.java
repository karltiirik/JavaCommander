package com.nortal.commander;

import java.io.File;
import java.util.List;

/**
 * Created by karl on 16.12.2014.
 */
public class Ls implements Command {
    public void execute(List<String> arguments, Environment environment) {
        if (arguments.isEmpty()){
            printFilesAndFolderInDir(environment.getCurrentDir());
        } else {
            for (String dir : arguments){
                printFilesAndFolderInDir(dir);
            }
        }
    }

    private static void printFilesAndFolderInDir(String path){
        File dir = new File(path);
        for (File f : dir.listFiles()) {
            System.out.print(f.getName()+ " ");
        }
        System.out.println("");
    }
}
