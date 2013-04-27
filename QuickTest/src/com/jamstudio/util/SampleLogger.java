package com.jamstudio.util;

/**
 * User: james
 * Date: 4/27/13
 * Time: 2:35 PM
 */
public class SampleLogger {
    public static void LogAsERR(String log) {
        System.err.println(">@ERR: " + log);
    }
    public static void LogAsOK(String log) {
        System.out.println(">@OK: " + log);
    }
}
