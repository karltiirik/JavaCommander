package com.nortal.commander;

import java.io.File;
import java.util.List;

/**
 * Created by karl on 17.12.2014.
 */
public class Tree implements Command {
    public void execute(List<String> arguments, Environment environment) {
        File dir = new File(environment.getCurrentDir());
        String dirTree = printDirectoryTree(dir);
        System.out.println(dirTree);
    }

    public static String printDirectoryTree(File folder) {
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        return sb.toString();
    }

    private static void printDirectoryTree(File dir, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent) + "├─" + dir.getName() + "\n");
        File[] filesAndFolders = dir.listFiles();
        for (int i = 0; i < filesAndFolders.length;i++){
            if (filesAndFolders[i].isDirectory()){
                    printDirectoryTree(filesAndFolders[i], indent + 1, sb);
            } else {
                if (i == filesAndFolders.length-1){
                    printFile(filesAndFolders[i], indent + 1, sb, true);
                } else {
                    printFile(filesAndFolders[i], indent + 1, sb, false);
                }

            }
        }
    }

    private static void printFile(File dir, int indent, StringBuilder sb, boolean lastFile) {
        sb.append(getIndentString(indent));
        if(lastFile){
            sb.append("└─");
        } else {
            sb.append("├─");
        }
        sb.append(dir.getName() + "\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
                sb.append("│  ");
        }
        return sb.toString();
    }

}
