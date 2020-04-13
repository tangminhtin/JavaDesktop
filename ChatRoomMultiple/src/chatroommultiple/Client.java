/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroommultiple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Client {

    private InetAddress host; // create host
    private int port; // create port

    /**
     * constructor of Client
     *
     * @param host
     * @param port
     */
    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * execute
     *
     * @throws IOException IOException
     */
    private void execute() throws IOException {
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // get user name

        Socket client = new Socket(host, port); // create client with host and port

        ReadClient readClient = new ReadClient(client); // create read client
        readClient.start(); // start read client

        WriteClient writeClient = new WriteClient(client, name); // create write client
        writeClient.start(); // start write client
    }

    /**
     * main
     *
     * @param args args
     * @throws UnknownHostException UnknownHostException
     * @throws IOException IOException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        Client client = new Client(InetAddress.getLocalHost(), 5555); // create client
        client.execute(); // execute client
    }
}

class ReadClient extends Thread {

    private Socket client; // create socket

    /**
     * Constructor of ReadClient
     *
     * @param client client
     */
    public ReadClient(Socket client) {
        this.client = client;
    }

    /**
     * override run method
     */
    @Override
    public void run() {
        DataInputStream dis = null; // create data input stream

        try {
            dis = new DataInputStream(client.getInputStream()); // get input stream
            while (true) {
                String sms = dis.readUTF(); // read UTF
                System.out.println(sms); // out message
            }
        } catch (IOException ex) {
            try {
                dis.close(); // close data input stream
                client.close(); // close client
            } catch (IOException ex1) {
                System.out.println("Ending server...");
            }
        }
    }

}

class WriteClient extends Thread {

    private Socket client; // create client
    private String name; // store user name

    /**
     * Constructor of WriteClient
     *
     * @param client client
     * @param name name
     */
    public WriteClient(Socket client, String name) {
        this.client = client;
        this.name = name;
    }

    /**
     * override run method
     */
    @Override
    public void run() {
        DataOutputStream dos = null; // create data output stream
        try {
            dos = new DataOutputStream(client.getOutputStream()); // get data output stream
            Scanner scanner = new Scanner(System.in); // create scanner

            while (true) {
                String sms = scanner.nextLine(); // get input
                dos.writeUTF("[" + name + "]: " + sms); // out message
            }
        } catch (IOException ex) {
            try {
                dos.close(); // close data output stream
                client.close(); // close client
            } catch (IOException ex1) {
                System.out.println("Ending Server...");
            }
        }
    }
}
