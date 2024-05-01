package chatapp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost", 12345);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String msgToSend, msgToRec;

        while (true) {
            System.out.println("Enter text: ");
            msgToSend = sc.nextLine();
            out.writeUTF(msgToSend);

            if(msgToSend.equalsIgnoreCase("quit")) {
                in.close();
                out.close();
                sc.close();
                s.close();
                break;
            }
            msgToRec = in.readUTF();
            System.out.println("Server says: " + msgToRec);
        }
    }
}
