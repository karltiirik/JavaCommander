package com.nortal.commander;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Environment env = new Environment();

    public static void main(String[] args) {
        while (true) {
            System.out.print("# ");
            String input = new Scanner(System.in).nextLine();
            if (input.equals("exit")) {
                break;
            }
            Command command = getCommand(input);
            if (command != null) {
                command.execute(getArguments(input), env);
            } else {
                System.out.println("Unknown command: " + input);
            }
        }
    }

    private static Command getCommand(String commandLine) {
        if (commandLine.equals("echo") || commandLine.startsWith("echo ")) {
            return new Echo();
        } else if (commandLine.startsWith("export")) {
            return new Export();
        } else if (commandLine.equals("env")) {
            return new Env();
        } else if (commandLine.equals("date")) {
            return new Date();
        } else if (commandLine.equals("uptime")) {
            return new Uptime();
        } else if (commandLine.equals("ls") || commandLine.startsWith("ls ")) {
            return new Ls();
        } else if (commandLine.startsWith("cat ")) {
            return new Cat();
        } else if (commandLine.equals("tree")) {
            return new Tree();
        } else {
            return null;
        }
    }

    private static List<String> getArguments(String commandLine) {
        List<String> args = new ArrayList<String>();
        Scanner sc = new Scanner(commandLine);
        sc.next();
        while (sc.hasNext()) {
            args.add(sc.next());
        }
        return args;
    }
}

