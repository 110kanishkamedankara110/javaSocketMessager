/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javasocket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author BLACKBOX
 */
public class JavaSocket1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new server().runServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class server {

    public void runServer() throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("server 1 started");
        Socket socket = ss.accept();
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        
        while (true) {
          new Thread(() -> {
            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    os.writeUTF(sc.nextLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

            System.out.println(is.readUTF());
        }

    }
}
