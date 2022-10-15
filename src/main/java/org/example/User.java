package org.example;

public class User {

    private static TargetAddress targetAddress=TargetAddress.getInstance();
    private static Integer port= targetAddress.targetPort();
    private static String ip= targetAddress.targetIp();

    public static String ip(){
        return ip;
    }
    public static Integer port(){
        return port;
    }



}
