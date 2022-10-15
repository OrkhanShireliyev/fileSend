package org.example;

import java.util.Scanner;

public class FormPerson {
    public static String name,surname,userdata;

    public static String fullData(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter full name:  ");
        userdata=scanner.nextLine();
        String[] user=userdata.split("  ");
        if (user.length>1){
            name=user[0];
            surname=user[1];
        }else if(user.length==1 && user[0]!=""){
            name=user[0];
        }else {
            System.out.println("Wrong Answer!");
            System.out.println(Introduction.brace);
            fullData();
        }
        return userdata;
    }




}
