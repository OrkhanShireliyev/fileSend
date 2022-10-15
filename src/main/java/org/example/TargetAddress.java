package org.example;

import java.util.Scanner;

public class TargetAddress {
    String[] arr;
    String pai;

    private TargetAddress(){}

    private static TargetAddress targetAddress=null;

    public static TargetAddress getInstance(){
        if (targetAddress==null){
            targetAddress=new TargetAddress();
        }
        return targetAddress;

    }

    private String[] portAndIp(){
        if (pai==null){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter ip:port is target: ");
            pai=scanner.nextLine();

            if (!pai.contains(":")){
                System.out.println("You typed is wrong!");
                System.out.println(Introduction.brace);
                pai=null;
                portAndIp();
            }else {
                arr=pai.split(":");
            }

        }
        return arr;
    }

    public String targetIp() {
        String ip = null;
        try {
            ip = portAndIp()[0];
        } catch (NullPointerException exception) {
            System.out.println("IP error!");
            System.out.println(Introduction.brace);
            pai = null;
            portAndIp();

        }
        return ip;
    }

    public Integer targetPort(){
        Integer port=null;
        try{
            port=Integer.parseInt(portAndIp()[1]);
        }catch (NumberFormatException nfe){
            System.out.println("Port error!");
            System.out.println(Introduction.brace);
            pai=null;
            portAndIp();
        }catch (NullPointerException npe){
            System.out.println("The port is marked as an Integer!  ");
            System.out.println(Introduction.brace);
            pai=null;
            portAndIp();
        }
        return port;
    }



}
