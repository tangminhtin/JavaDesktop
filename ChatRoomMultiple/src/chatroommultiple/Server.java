/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroommultiple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Server {

    private int port;   // store port
    public static ArrayList<Socket> listSK; // list of socket

    /**
     * Constructor of Server
     *
     * @param port
     */
    public Server(int port) {
        this.port = port;
    }

    /**
     * execute
     *
     * @throws IOException IOException
     */
    private void execute() throws IOException {
        ServerSocket server = new ServerSocket(port); // create server sockect
        WriteServer writeServer = new WriteServer(); // write server
        writeServer.start(); // start write server

        System.out.println("Server is listening...");

        while (true) {
            Socket socket = server.accept(); // accept server
            System.out.println("Connected with: " + socket);    // get current connected
            Server.listSK.add(socket); // add socket to array list
            ReadServer readServer = new ReadServer(socket); // create read server
            readServer.start(); // start read server
        }
    }

    /**
     * main
     *
     * @param args args
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        Server.listSK = new ArrayList<>(); // create new list
        Server server = new Server(5555); // create server
        server.execute(); // excute server
    }
}

class ReadServer extends Thread {

    private Socket socket; // store socket

    /**
     * Constructor of ReadServer
     *
     * @param client client
     */
    public ReadServer(Socket client) {
        this.socket = client;
    }

    /**
     * override run method
     */
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream()); // create data input stream
            while (true) {
                String sms = dis.readUTF(); // read UTF
                if (sms.contains("exit")) { // if word contains exit, then exit client
                    Server.listSK.remove(socket); // remove client
                    System.out.println("Ending connection with " + socket);
                    dis.close(); // close data input stream
                    socket.close(); // close socket
                    continue;
                }

                for (Socket item : Server.listSK) {
                    if (item.getPort() != socket.getPort()) { // if not equal to current port
                        DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                        dos.writeUTF(sms); // write message
                    }
                }
                System.out.println(sms); // out message
            }
        } catch (IOException ex) {
            try {
                socket.close(); // close socket
            } catch (IOException ex1) {
                System.out.println("Ending Server...");
            }
        }
    }
}

class WriteServer extends Thread {

    /**
     * override run method
     */
    @Override
    public void run() {
        DataOutputStream dos = null; // create data output string
        Scanner scanner = new Scanner(System.in); // create scanner

        while (true) {
            try {
                String sms = scanner.nextLine(); // Wait for server input data
                for (Socket item : Server.listSK) {
                    dos = new DataOutputStream(item.getOutputStream());
                    dos.writeUTF("Server: " + sms); // wirte message
                }
            } catch (IOException e) { // out error
                e.printStackTrace();
            }
        }
    }

}
