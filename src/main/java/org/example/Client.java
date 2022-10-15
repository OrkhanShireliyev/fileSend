package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        //Istifadeci melumati
        Introduction.intro();
        FormPerson.fullData();
        String name = FormPerson.name;

        //Client ucun
        Socket server;

        //Giris-cixis ucun
        DataInputStream dis;
        DataOutputStream dos;

        //Deyisenler ucun
        String ip = User.ip();
        Integer port = User.port();

        try {
            //Porta qosulmaq
            server = new Socket(ip, port);
            System.out.println("Connected is successfully!");
            System.out.println(Introduction.brace);
            //int menu=Introduction.menu();

            //Giris emeliyyatlari
            dis = new DataInputStream(server.getInputStream());
            //Cixis emeliyyatlari
            dos = new DataOutputStream(server.getOutputStream());

            //File
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the received file name:  ");
            String fileName = scanner.nextLine();
            String format = dis.readUTF();
            byte[] bytes = messageServer(dis);

            FileUtility.writeBytes("C:\\Users\\FX506ICB\\OneDrive\\Pictures\\Saved Pictures" + fileName + "." + format, bytes);

            System.out.println("Received successfuly!");

            dis.close();
            dos.close();

        } catch (SocketException se) {
            System.out.println("Socket error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] messageServer(DataInputStream dis)throws IOException{
        int msgLen=dis.readInt();
        byte[] bytes=new byte[msgLen];
        dis.readFully(bytes);

        return bytes;

    }
}
