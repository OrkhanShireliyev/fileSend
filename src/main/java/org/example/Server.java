package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //Istifadeci melumati
        Introduction.intro();
        FormPerson.fullData();
        String name = FormPerson.name;

        //Server ucun
        ServerSocket server;
        Socket client;

        //Input almaq ucun
        Scanner scanner;

        //Giris-cixis ucun
        DataOutputStream dos;
        DataInputStream dis;

        //Deyisenler ucun
        Integer port = User.port();

       try {
           //Port acmaq ve elaqelendirmeq
           server=new ServerSocket(port);
           System.out.println("Waiting for connection...");
           client=server.accept();
           System.out.println("Connected is successfuly!");
           System.out.println(Introduction.brace);
           //int menu=Introduction.menu();

           //Giris emeliyyatlari
           dos=new DataOutputStream(client.getOutputStream());
           //Cixis emeliyyatlari
           dis=new DataInputStream(client.getInputStream());

           //File oxuma emrleri
           System.out.println("Enter the file way:  ");
           scanner=new Scanner(System.in);
           String fileWay=scanner.nextLine();
           // "C:\Users\FX506ICB\OneDrive\Pictures\Saved Pictures\1660558238983.jpg"
           String[] format=fileWay.split("\\.");

           byte[] array=FileUtility.readBytes(fileWay);
           dos.writeUTF(format[1]);
           dos.writeInt(array.length);
           dos.write(array);
           System.out.println("Sended successfuly");

           dos.close();
           dis.close();

       }catch (NullPointerException npe){
           System.out.println(npe.getMessage()+"! ");
           System.out.println(Introduction.brace);
       }catch (IOException e){
           System.out.println(e.getMessage()+"! ");
       }catch (Exception e1){
           System.out.println("An unexpected error occured: ");
           e1.printStackTrace();
           System.out.println(Introduction.brace);

       }








    }










}
