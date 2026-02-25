package org.sada.util;

import java.time.LocalDateTime;

public class Logger {
    private static boolean enabled = true;

    public static void info(String message){
       log("INFO", message);
    }

    public static void warn(String message){
        log("WARN", message);
    }

    public static void error(String message){
        log("ERROR", message);
    }

    public static void input(String message){
        log("INPUT?", message);
    }

    private static void log(String level, String message){
        if (!enabled) {return;}

        System.out.println(
                LocalDateTime.now() + ": " + level + ": " + message + "\n"
        );
    }

    public static void setEnabled(boolean enabled) {
        Logger.setEnabled(enabled);
    }
}



