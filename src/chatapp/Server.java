package chatapp;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Waiting for connection......");
        Socket s = serverSocket.accept();
        System.out.println("Connection established.....");

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String msgToSend, msgToRec;
        while(true) {
            msgToRec = in.readUTF();
            System.out.println("Client says: " + msgToRec);
            if(msgToRec.equalsIgnoreCase("quit")) {
                in.close();
                out.close();
                sc.close();
                s.close();
                serverSocket.close();
                break;
            }
            System.out.println("Enter text: ");
            msgToSend = sc.nextLine();
            out.writeUTF(msgToSend);
        } 
    }
}
